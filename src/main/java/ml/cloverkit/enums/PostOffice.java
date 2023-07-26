// 邮局建模
package ml.cloverkit.enums;

import ml.cloverkit.Enums;

import java.util.Iterator;

class Mail {
    /**
     * 以下枚举描述了一封信的基本要素
     */
    // NO 减少了随机选择的可能性
    enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 }
    enum Scannability { UNSCANNABLE, YES1, YES2, YES3, YES4 }
    enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 }
    enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6 }
    enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this + ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    // 生成测试邮件
    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    // 实现 Iterable 可用于批量生成测试邮件和使用 foreach 循环 ♻️
    public static Iterable<Mail> generator(final int counter)  {
        return new Iterable<>() {
            int n = counter;

            @Override
            public Iterator<Mail> iterator() {
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return n-- > 0;
                    }

                    @Override
                    public Mail next() {
                        return randomMail();
                    }

                    @Override
                    public void remove() {  // 未实现
                        throw new UnsupportedOperationException();
                    }
                };
            }
            ;
        };
    }
}

public class PostOffice {
    // 邮件处理器枚举 (责任链模式)
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE: return false;
                    default:
                        // 居然还能嵌套 switch 🤔️
                        switch (m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE: return false;
                    default:
                        switch (m.address) {
                            case INCORRECT: return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING: return false;
                    default:
                        System.out.println("Returning " + m + " to sender");
                        return true;
                }
            }
        }
        ;
        // 常量特定方法定义
        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        // 按照 MailHandler 中定义的 Handler 枚举顺序依次尝试处理信件 (责任链模式)
        for (MailHandler handler : MailHandler.values())
            if (handler.handle(m))
                return;
        // 如果没有一个 handler 可以处理信件，会走到这里说明这封信为 “死信”
        System.out.println(m + " is a dead letter");
    }

    public static void main(String[] args) {
        // Mail 的 generator 方法返回一个 Iterable 可以使用 foreach 遍历
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*******");
        }
    }
}
