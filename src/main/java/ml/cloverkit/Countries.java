// 用享元模式设计的 Map 和 List，包含样例数据
package ml.cloverkit;

import java.util.*;

public class Countries {
    // 这块数据太多，从 onjava 代码样例中复制
    private static final String[][] DATA = {
            // 非洲
            {"ALGERIA","Algiers"},
            {"ANGOLA","Luanda"},
            {"BENIN","Porto-Novo"},
            {"BOTSWANA","Gaberone"},
            {"BURKINA FASO","Ouagadougou"},
            {"BURUNDI","Bujumbura"},
            {"CAMEROON","Yaounde"},
            {"CAPE VERDE","Praia"},
            {"CENTRAL AFRICAN REPUBLIC","Bangui"},
            {"CHAD","N'djamena"},
            {"COMOROS","Moroni"},
            {"CONGO","Brazzaville"},
            {"DJIBOUTI","Dijibouti"},
            {"EGYPT","Cairo"},
            {"EQUATORIAL GUINEA","Malabo"},
            {"ERITREA","Asmara"},
            {"ETHIOPIA","Addis Ababa"},
            {"GABON","Libreville"},
            {"THE GAMBIA","Banjul"},
            {"GHANA","Accra"},
            {"GUINEA","Conakry"},
            {"BISSAU","Bissau"},
            {"COTE D'IVOIR (IVORY COAST)","Yamoussoukro"},
            {"KENYA","Nairobi"},
            {"LESOTHO","Maseru"},
            {"LIBERIA","Monrovia"},
            {"LIBYA","Tripoli"},
            {"MADAGASCAR","Antananarivo"},
            {"MALAWI","Lilongwe"},
            {"MALI","Bamako"},
            {"MAURITANIA","Nouakchott"},
            {"MAURITIUS","Port Louis"},
            {"MOROCCO","Rabat"},
            {"MOZAMBIQUE","Maputo"},
            {"NAMIBIA","Windhoek"},
            {"NIGER","Niamey"},
            {"NIGERIA","Abuja"},
            {"RWANDA","Kigali"},
            {"SAO TOME E PRINCIPE","Sao Tome"},
            {"SENEGAL","Dakar"},
            {"SEYCHELLES","Victoria"},
            {"SIERRA LEONE","Freetown"},
            {"SOMALIA","Mogadishu"},
            {"SOUTH AFRICA","Pretoria/Cape Town"},
            {"SUDAN","Khartoum"},
            {"SWAZILAND","Mbabane"},
            {"TANZANIA","Dodoma"},
            {"TOGO","Lome"},
            {"TUNISIA","Tunis"},
            {"UGANDA","Kampala"},
            {"DEMOCRATIC REPUBLIC OF THE CONGO (ZAIRE)",
                    "Kinshasa"},
            {"ZAMBIA","Lusaka"},
            {"ZIMBABWE","Harare"},
            // 亚洲
            {"AFGHANISTAN","Kabul"},
            {"BAHRAIN","Manama"},
            {"BANGLADESH","Dhaka"},
            {"BHUTAN","Thimphu"},
            {"BRUNEI","Bandar Seri Begawan"},
            {"CAMBODIA","Phnom Penh"},
            {"CHINA","Beijing"},
            {"CYPRUS","Nicosia"},
            {"INDIA","New Delhi"},
            {"INDONESIA","Jakarta"},
            {"IRAN","Tehran"},
            {"IRAQ","Baghdad"},
            {"ISRAEL","Jerusalem"},
            {"JAPAN","Tokyo"},
            {"JORDAN","Amman"},
            {"KUWAIT","Kuwait City"},
            {"LAOS","Vientiane"},
            {"LEBANON","Beirut"},
            {"MALAYSIA","Kuala Lumpur"},
            {"THE MALDIVES","Male"},
            {"MONGOLIA","Ulan Bator"},
            {"MYANMAR (BURMA)","Rangoon"},
            {"NEPAL","Katmandu"},
            {"NORTH KOREA","P'yongyang"},
            {"OMAN","Muscat"},
            {"PAKISTAN","Islamabad"},
            {"PHILIPPINES","Manila"},
            {"QATAR","Doha"},
            {"SAUDI ARABIA","Riyadh"},
            {"SINGAPORE","Singapore"},
            {"SOUTH KOREA","Seoul"},
            {"SRI LANKA","Colombo"},
            {"SYRIA","Damascus"},
            {"THAILAND","Bangkok"},
            {"TURKEY","Ankara"},
            {"UNITED ARAB EMIRATES","Abu Dhabi"},
            {"VIETNAM","Hanoi"},
            {"YEMEN","Sana'a"},
            // 大洋洲
            {"AUSTRALIA","Canberra"},
            {"FIJI","Suva"},
            {"KIRIBATI","Bairiki"},
            {"MARSHALL ISLANDS","Dalap-Uliga-Darrit"},
            {"MICRONESIA","Palikir"},
            {"NAURU","Yaren"},
            {"NEW ZEALAND","Wellington"},
            {"PALAU","Koror"},
            {"PAPUA NEW GUINEA","Port Moresby"},
            {"SOLOMON ISLANDS","Honaira"},
            {"TONGA","Nuku'alofa"},
            {"TUVALU","Fongafale"},
            {"VANUATU","Port Vila"},
            {"WESTERN SAMOA","Apia"},
            // 欧洲
            {"ALBANIA","Tirana"},
            {"ANDORRA","Andorra la Vella"},
            {"AUSTRIA","Vienna"},
            {"BELGIUM","Brussels"},
            {"BOSNIA-HERZEGOVINA","Sarajevo"},
            {"CROATIA","Zagreb"},
            {"CZECH REPUBLIC","Prague"},
            {"DENMARK","Copenhagen"},
            {"ESTONIA","Tallinn"},
            {"FINLAND","Helsinki"},
            {"FRANCE","Paris"},
            {"GERMANY","Berlin"},
            {"GREECE","Athens"},
            {"HUNGARY","Budapest"},
            {"ICELAND","Reykjavik"},
            {"IRELAND","Dublin"},
            {"ITALY","Rome"},
            {"LATVIA","Riga"},
            {"LIECHTENSTEIN","Vaduz"},
            {"LITHUANIA","Vilnius"},
            {"LUXEMBOURG","Luxembourg"},
            {"MACEDONIA","Skopje"},
            {"MALTA","Valletta"},
            {"MONACO","Monaco"},
            {"MONTENEGRO","Podgorica"},
            {"THE NETHERLANDS","Amsterdam"},
            {"NORWAY","Oslo"},
            {"POLAND","Warsaw"},
            {"PORTUGAL","Lisbon"},
            {"ROMANIA","Bucharest"},
            {"SAN MARINO","San Marino"},
            {"SERBIA","Belgrade"},
            {"SLOVAKIA","Bratislava"},
            {"SLOVENIA","Ljuijana"},
            {"SPAIN","Madrid"},
            {"SWEDEN","Stockholm"},
            {"SWITZERLAND","Berne"},
            {"UNITED KINGDOM","London"},
            {"VATICAN CITY","Vatican City"},
            // 中北美洲
            {"ANTIGUA AND BARBUDA","Saint John's"},
            {"BAHAMAS","Nassau"},
            {"BARBADOS","Bridgetown"},
            {"BELIZE","Belmopan"},
            {"CANADA","Ottawa"},
            {"COSTA RICA","San Jose"},
            {"CUBA","Havana"},
            {"DOMINICA","Roseau"},
            {"DOMINICAN REPUBLIC","Santo Domingo"},
            {"EL SALVADOR","San Salvador"},
            {"GRENADA","Saint George's"},
            {"GUATEMALA","Guatemala City"},
            {"HAITI","Port-au-Prince"},
            {"HONDURAS","Tegucigalpa"},
            {"JAMAICA","Kingston"},
            {"MEXICO","Mexico City"},
            {"NICARAGUA","Managua"},
            {"PANAMA","Panama City"},
            {"ST. KITTS AND NEVIS","Basseterre"},
            {"ST. LUCIA","Castries"},
            {"ST. VINCENT AND THE GRENADINES","Kingstown"},
            {"UNITED STATES OF AMERICA","Washington, D.C."},
            // 南美洲
            {"ARGENTINA","Buenos Aires"},
            {"BOLIVIA","Sucre (legal)/La Paz(administrative)"},
            {"BRAZIL","Brasilia"},
            {"CHILE","Santiago"},
            {"COLOMBIA","Bogota"},
            {"ECUADOR","Quito"},
            {"GUYANA","Georgetown"},
            {"PARAGUAY","Asuncion"},
            {"PERU","Lima"},
            {"SURINAME","Paramaribo"},
            {"TRINIDAD AND TOBAGO","Port of Spain"},
            {"URUGUAY","Montevideo"},
            {"VENEZUELA","Caracas"},
    };
    // 通过实现 entrySet() 来使用 AbstractMap
    private static class FlyweightMap extends AbstractMap<String, String> {

        private static class Entry implements Map.Entry<String, String> {
            int index;

            Entry(int index) {
                this.index = index;
            }

            @Override
            public boolean equals(Object o) {
                return o instanceof FlyweightMap &&
                        Objects.equals(DATA[index][0], 0);
            }

            @Override
            public int hashCode() {
                return Objects.hashCode(DATA[index][0]);
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }
        }

        // 实现 AbstractSet 的 size() 和 iterator 方法
        static class EntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;

            EntrySet(int size) {
                if (size < 0)
                    this.size = 0;
                // 不能比 DATA 数组大
                else if (size > DATA.length)
                    this.size = DATA.length;
                else
                    this.size = size;
            }

            private class Iter implements Iterator<Map.Entry<String, String>> {
                // 每个 Iterator 只有一个 Entry 对象
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index < size - 1;
                }

                @Override
                public Map.Entry<String, String> next() {
                    entry.index++;
                    return entry;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new Iter();
            }

            @Override
            public int size() {
                return size;
            }
        }

        private static Set<Map.Entry<String, String>> entries = new EntrySet(DATA.length);

        @Override
        public Set<Map.Entry<String, String>> entrySet() {
            return entries;
        }
    }

    // 创建一个由 'size' 个国家组成的映射:
    static Map<String, String> select(final int size) {
        return new FlyweightMap() {
            @Override
            public Set<Map.Entry<String, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    static Map<String, String> map = new FlyweightMap();

    public static Map<String, String> capitals() {
        // 整个映射
        return map;
    }

    public static Map<String, String> capitals(int size) {
        // 部分映射
        return select(size);
    }

    static List<String> names = new ArrayList<>(map.keySet());

    // 所有的国名
    public static List<String> names() {
        return names;
    }

    // 部分列表:
    public static List<String> names(int size) {
        return new ArrayList<>(select(size).keySet());
    }

    public static void main(String[] args) {
        System.out.println(capitals(10));
        System.out.println(names(10));
        System.out.println(new HashMap<>(capitals(3)));
        System.out.println(new LinkedHashMap<>(capitals(3)));
        System.out.println(new TreeMap<>(capitals(3)));
        System.out.println(new Hashtable<>(capitals(3)));
        System.out.println(new HashSet<>(names(6)));
        System.out.println(new LinkedHashSet<>(names(6)));
        System.out.println(new TreeSet<>(names(6)));
        System.out.println(new ArrayList<>(names(6)));
        System.out.println(new LinkedList<>(names(6)));
        System.out.println(capitals().get("BRAZIL"));
    }
}
