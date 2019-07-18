package ac.kr.ajou.dirt;

//숙제********************기존 code를 이해하고 test code를 만들고 refactoring을 한다. 최종코드를 작성하고, README에 refactoring한 방법을 쓰자.
class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;//A,B,S의 이름이 매칭이 되지 않으며 quality > 0 인 경우
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;//A나 B의 이름이 매칭되며, quality < 50 인 경우

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;//B의 이름이 매칭되며, sellIn < 11 이고 quality < 50 인 경우
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;//B의 이름이 매칭되며, sellIn < 6 이고 quality < 50 인 경우
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;//S의 이름이 매칭되지 않는 경우
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;//A,B,S의 이름이 매칭되지 않고 quality > 0 이고 sellIn < 0 인 경우
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;//B의 이름이 매칭되며, sellIn < 0 인 경우
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;//A의 이름이 매칭되며, sellIn < 0 이며 quality < 50 인 경우
                    }
                }
            }
        }
    }
}