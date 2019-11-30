package com.ithb.jeffry.tourdestinationcatalogue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

class LocationData {
    private static String[] locationNames = {
            "Hongkong",
            "London, England",
            "Singapore",
            "Bangkok, Thailand",
            "Paris, France",
            "Macau",
            "Shenzen, China",
            "New York",
            "Istanbul, Turkey",
            "Kuala Lumpur, Malaysia",
            "Antalya, Turkey",
            "Dubai, United Arab Emirates",
            "Seoul, South Korea",
            "Rome, Italy",
            "Taipei, Taiwan"
    };

    private static String[] locationShortDescs = {
            "Chinese special administrative region",
            "Capital of England",
            "Country in Asia",
            "Capital of Thailand",
            "Capital of France",
            "Chinese special administrative region",
            "City in China",
            "City in New York",
            "City in Turkey",
            "Capital of Malaysia",
            "City in Turkey",
            "City in the United Arab Emirates",
            "Capital of South Korea",
            "Capital of Italy",
            "Capital of Taiwan",
    };

    private static String[] locationCurrencies = {
            "Hong Kong Dollar (HKD)",
            "Pound Sterling (GBP)",
            "Singapore Dollar (SGD)",
            "Thai Baht (THB)",
            "Euro (EUR)",
            "Macanese Pataca (MOP)",
            "Yuan (RMB)",
            "United States Dollar (USD)",
            "Turkish Lira (TRY)",
            "Malaysian Ringgit (MYR)",
            "Turkish Lira (TRY)",
            "Dirham (AED)",
            "South Korean Won (KRW)",
            "Euro (EUR)",
            "New Taiwan Dollar (TWD)"
    };

    private static String[] locationLanguages = {
            "Chinese, English",
            "English",
            "English, Malay, Chinese, Tamil",
            "Thai",
            "French",
            "Chinese, Portuguese",
            "Mandarin",
            "English",
            "Turkish",
            "Malay",
            "Turkish",
            "Arabic",
            "Korean",
            "Latin",
            "Taiwanese Mandarin"
    };

    private static String[] locationHotelPriceRanges = {
            "Rp688,090 - Rp2,098,241",
            "Rp1,710,084 - Rp5,881,534",
            "Rp1,204,341 - Rp4,003,137",
            "Rp447,403 - Rp1,696,712",
            "Rp2,591,799 - Rp6,814,396",
            "Rp1,709,316 - Rp7,160,100",
            "Rp573,682 - Rp1,339,941",
            "Rp3,926,853 - Rp9,050,262",
            "Rp276,316 - Rp4,137,771",
            "Rp357,818 - Rp1,208,670",
            "Rp537,757 - Rp1,137,169",
            "Rp765,002 - Rp2,172,674",
            "Rp955,031 - Rp2,800,750",
            "Rp1,610,548 - Rp5,365,806",
            "Rp839,890 - Rp2,442,548"
    };

    private static String[] locationFlightDurationPrice = {
            "4 h 55 min,\nfrom Rp3,147,000",
            "16 h 15 min,\nfrom Rp11,350,792",
            "1 h 40 min,\nfrom Rp985,990",
            "3 h 25 min,\nfrom Rp1,740,000",
            "15 h 35 min,\nfrom Rp6,158,300",
            "6h 0 min,\nfrom Rp3,212,000",
            "5 h 15 min,\nfrom Rp3,689,320",
            "19 h 30 min,\nfrom Rp8,862,700",
            "12 h 50 min,\nfrom Rp8,124,500",
            "1 h 50 min,\nfrom Rp1,039,900",
            "14 h 50 min,\nfrom Rp12,707,600",
            "7 h 55 min,\nfrom Rp7,839,559",
            "7 h 10 min,\nfrom Rp4,252,000",
            "16 h 25 min,\nfrom Rp11,163,000",
            "5 h 25 min,\nfrom Rp2,423,000"
    };

    private static String[] locationFunFacts = {
            "Hong Kong is the second-biggest creditor nation by net international investment position per capita (176,694 USD). wikipedia.org",
            "London is the most-populous city in the European Union by population within city limits (9,126,366). wikipedia.org",
            "Singapore has the fifth-largest merchant navy by capacity (59.2 million gross register tonnage). wikipedia.org",
            "As you may already know, Bangkok has the longest name of any city in the world, but locally it’s just called ‘Krungthep’ – ‘city of angels’.\n" +
                    "\n" +
                    "The full name? Krung Thep Mahanakhon Amon Rattanakosin Mahinthara Ayuthaya Mahadilok Phop Noppharat Ratchathani Burirom Udomratchaniwet Mahasathan Amon Piman Awatan Sathit Sakkathattiya Witsanukam Prasit.\n" +
                    "\n" +
                    "If you learn how to say the whole thing we guarantee you’ll become an instant hero.",
            "Paris is the ninth-most-populous European city by population within city limits (2,140,526). wikipedia.org",
            "The name ‘Macau’ is thought to have been coined through a misunderstanding by Portuguese seafarers when they first arrived on the island. They asked the locals for the name of the land, but the locals misunderstood, and answered with ‘A-Ma-Gau’, thinking that the Portuguese were asking for the name of the local temple called A-Ma. From there, the Portuguese took ‘A-Ma-Gau’ and the territory officially became known as Macau.",
            "Shenzhen is the 10th-most-populous city proper in the world by population (12,528,300). wikipedia.org",
            "New York City is the sixth-most densely populated city in the United States (27,016.3 people per square mile). wikipedia.org",
            "Istanbul is the fourth-most-populous city proper in the world by population (15,029,231). wikipedia.org",
            "Kuala Lumpur has the second-highest GDP (217,818 million Malaysian ringgit) among all Malaysian states. wikipedia.org",
            "Antalya is the largest Turkish city on the Mediterranean coast region. Therefore, it is often taken as a gateway to the Turkish Riviera. It is also the capital of the Turkish Mediterranean coast.",
            "Dubai ranks fourth in the world for number of skyscrapers (190). wikipedia.org",
            "Seoul is the ninth-most-populous national capital by population (9,989,795). wikipedia.org",
            "Rome is the fourth-most-populous city in the European Union by population within city limits (2,857,046). wikipedia.org",
            "Between 2004-2010, Taipei Tower was considered the tallest building in the world. It is now outranked by the Burj Dubai in Dubai. The total cost of construction was estimated around $1,600,000,000."
    };

    private static String[] locationDetails = {
            "Hongkong is the number one destination for tourists with 27.77 million visitors. When you're here, visit the Avenue of the Stars, Disneyland, Victoria's Peak and Ocean Park.",
            "Taking the second spot is London with 17.38 million international tourists. According to the data gathered, it is the number one most visited destination in Europe. If you're visiting this city, take time to see the Buckingham Palace, Westminster Abbey and Big Ben!",
            "Singapore is at number 3 with 17.09 tourists and it continues to rake in visitors consistently. Be ready to be amazed at the Marina Bay Sands, Gardens by the Bay and the Singapore Zoo.",
            "Number 4 on the list of most visited destinations, Bangkok had 6.5 million tourists in 2014. Don't forget to visit the Grand Palace, Dusit Palace and the Wat Traimit when you're in Bangkok. Have fun shopping at the night market, too.",
            "It would be correct to say that Paris will forever be on the list of most visited cities because of its charm and beauty. It had a total of 14.98 million tourists, though it was a 1.9% decline from 2013. Of course, you have to see the Eiffel Tower, The Louvre and Arc de Triomphe when you're in the City of Lights.",
            "Nicknamed the Las Vegas of the East, Macau had a staggering 14.97 million international tourist visits in 2014. The theme parks and casinos are sure to draw in more tourists in the next years. Drop by the Ruins of St. Paul and the Macau Tower when you decide to go to Macau.",
            "Now considered an economic powerhouse, Shenzhen got a total of 13.1 million tourists from around the world. Check out the Fairy Lake Botanical Garden and the China Folk Cultural Village when you visit this tourist destination.",
            "It should be no surprise that New York is number 8 on the list with its 12.23 million visitors. The City That Never Sleeps is best known for the Statue of Liberty, Central Park and Times Square.",
            "A staggering 11.87 million visitors is the reason for Istanbul to be on the number 9 spot on the list. Tourists marveled at the Blue Mosque, Hippodrome, and the Yedikule Fortress.",
            "Attracting 11.63 million visitors, Kuala Lumpur is the 6th most visited city in Asia. When you happen to stop by KL, check out the Petronas Twin Towers, the Batu Caves and the Thean Hou Temple.",
            "Antalya is a Mediterranean resort town located in southwest Turkey. It was able to gather 11.5 million tourists, majority of whom are Russian. Sites to see include the Roman Fortress, Karst Springs and the Antalya Museum.",
            "As the city rapidly expands its infrastructure, the number of visitors continues to rise as well. In 2014 alone, Dubai was able to garner 11.39 million tourists to its city. Don't miss out on seeing the Burj Khalifa, Dubai Aquarium and the Bastakia when you plan to visit the city.",
            "Slowly but surely, Seoul rose in the list with 9.39 million tourist visitors from the world over. When in South Korea, don't forget to pass by the Seoul Tower, Lotte World and the Jongmyo Shrine.",
            "Consistently visited by both local and international tourists, Rome gathered 8.78 million visitors and this could be attributed to St. Peter's Basilica, the Trevi Fountain and the Pantheon.",
            "At number 15 is Taipei which had a total of 8.6 million visits from people around the world. The world's largest national museum could be one of the reasons for the huge number of tourist influx to the city. Other sites to check out include Taipei 101, Chiang Kai Shek Memorial and Beitou Hotsprings."
    };

    private static String[] locationImages = {
            "https://www.elitereaders.com/wp-content/uploads/2016/02/hongkong.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/london.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/Singapore.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/bangkok.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/paris.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/macau.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/shenzhen.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/new-york.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/istanbul.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/kuala-lumpur.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/antalya.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/dubai.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/seoul.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/rome.jpg",
            "https://www.elitereaders.com/wp-content/uploads/2016/02/taipei.jpg"
    };

    static ArrayList<Location> getLocationData() {
        ArrayList<Location> list = new ArrayList<>();

        for (int position = 0; position < locationNames.length; position++) {
            Location location = new Location();
            location.setPosition(position);
            location.setName(locationNames[position]);
            location.setShortDesc(locationShortDescs[position]);
            location.setCurrency(locationCurrencies[position]);
            location.setLanguage(locationLanguages[position]);
            location.setHotelPriceRange(locationHotelPriceRanges[position]);
            location.setFlightDurationPrice(locationFlightDurationPrice[position]);
            location.setFunFact(locationFunFacts[position]);
            location.setDetail(locationDetails[position]);
            location.setPhoto(locationImages[position]);
            list.add(location);
        }

        return list;
    }

    static ArrayList<Location> getSelectedLocationData(int currentPosition){
        LinkedList<Integer> index = new LinkedList<>();
        ArrayList<Location> dataList = getLocationData();
        ArrayList<Location> result = new ArrayList<>();

        for (int i = 0; i < dataList.size(); i++) {
            if (i != currentPosition) {
                index.add(i);
            }
        }

        Collections.shuffle(index);

        for (int dataIterator = 0; dataIterator < 5; dataIterator++) {
            result.add(dataList.get(index.get(dataIterator)));
        }

        return result;
    }
}
