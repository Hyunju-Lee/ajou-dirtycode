package ac.kr.ajou.dirt;

//숙제********************기존 code를 이해하고 test code를 만들고 refactoring을 한다. 최종코드를 작성하고, README에 refactoring한 방법을 쓰자.
class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if(items[i].name.equals("Aged Brie")){
                updateAgedBrie(i);

            } else if(items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")){
                backstagePassesToA_TAFKAL80ETC_Concert(items[i]);

            } else if(items[i].name.equals("Sulfuras, Hand of Ragnaros")){
                //아무것도 안한다.
            } else {
                updateOtherName(items[i]);
            }
        }
    }

    private void updateOtherName(Item item) {
        //A,B,S의 이름이 매칭이 되지 않으며 quality > 0 인 경우 - quality1감소
        if (item.quality > 0){
            item.quality--;
        }
        //S의 이름이 매칭되지 않는 경우 - sellIn1감소
        item.sellIn--;
        //A,B,S의 이름이 매칭되지 않고 quality > 0 이고 sellIn < 0 인 경우 - quality1감소
        if (item.quality > 0 && item.sellIn < 0){
            item.quality--;
        }
    }

    private void backstagePassesToA_TAFKAL80ETC_Concert(Item item) {
        //A나 B의 이름이 매칭되며, quality < 50 인 경우 - quality1증가
        if (item.quality < 50) {
            item.quality++;
        }
        //B의 이름이 매칭되며, sellIn < 11 이고 quality < 50 인 경우 - quality1증가
        if(item.sellIn < 11 && item.quality < 50){
            item.quality++;
        }
        //B의 이름이 매칭되며, sellIn < 6 이고 quality < 50 인 경우 - quality1증가
        if(item.sellIn < 6 && item.quality < 50){
            item.quality++;
        }
        //S의 이름이 매칭되지 않는 경우 - sellIn1감소
        item.sellIn--;
        //B의 이름이 매칭되며, sellIn < 0 인 경우 - quality 0으로 초기화
        if(item.sellIn < 0){
            item.quality = 0;
        }
    }

    private void updateAgedBrie(int i) {
        //S의 이름이 매칭되지 않는 경우 - sellIn1감소
        items[i].sellIn--;
        //A나 B의 이름이 매칭되며, quality < 50 인 경우 - quality1증가
        if (items[i].quality < 50) {
            items[i].quality++;
        }
        //A의 이름이 매칭되며, sellIn < 0 이며 quality < 50 인 경우 - quality1증가
        if(items[i].sellIn < 0 && items[i].quality < 50){
            items[i].quality++;
        }
    }
}