package lesson8;

public class LinkedHashTableImpl<K, V> extends HashTableImpl<K, V> {

    /**
     * Добавлена ссылка на следующий объект в цепочке
     */
    static class Item<K, V> extends HashTableImpl.Item<K, V> {

        private Item<K, V> nextItem;

        public Item(K key, V value) {
            super(key, value);
        }

        public Item<K, V> getNextItem() {
            return nextItem;
        }

        public void setNextItem(Item<K, V> nextItem) {
            this.nextItem = nextItem;
        }
    }

    /**
     * Переопределен массив с хранимыми объектами для нового Item
     */
    protected final Item<K, V>[] data;

    /**
     * Новый конструктор
     *
     * @param initialCapacity емкость массива
     */
    public LinkedHashTableImpl(int initialCapacity) {
        super(0);
        this.data = new Item[initialCapacity];
    }

    @Override
    protected int hashFunc(K key) {
        return key.hashCode() % data.length;
    }

    /**
     * Метод добавляет в ячейку массива объект, если ячейка занята, то объекты выстраиваются в цепочку
     */
    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);

        Item<K, V> item = data[index];
        Item<K, V> nextItem;

        if (item != null) {

            while (true) {
                nextItem = item.getNextItem();
                if (isKeysEqual(item, key)) {
                    item.setValue(value);
                    return true;
                }
                if (nextItem == null) {
                    item.setNextItem(new Item<>(key, value));
                    return true;
                }
                item = nextItem;
            }

        } else {
            data[index] = new Item<>(key, value);
        }
        size++;

        return true;
    }

    /**
     * Возвращает значение value для заданного key, если есть
     *
     * @param key ключ для поиска объекта Item
     * @return значение value объекта Item, null если не найдено
     */
    @Override
    public V get(K key) {
        int index = hashFunc(key);

        Item<K, V> item = data[index];
        while (item != null) {
            if (isKeysEqual(item, key)) {
                return item.getValue();
            }
            item = item.getNextItem();
        }
        return null;
    }

    /**
     * Удаляет объект из таблицы
     *
     * @param key ключ для поиска объекта Item
     * @return значение value объекта Item, null если не найдено
     */
    @Override
    public V remove(K key) {
        int index = hashFunc(key);

        Item<K, V> item = data[index];
        Item<K, V> previous = null;

        if (item != null) {
            do {

                if (isKeysEqual(item, key)) {
                    if (previous == null) {
                        data[index] = item.getNextItem();
                    } else {
                        previous.setNextItem(item.getNextItem());
                    }
                    return item.getValue();
                }
                previous = item;
                item = item.getNextItem();
            } while (item != null);
        }
        return null;
    }

    /**
     * Выводит все цепочку объектов для ячейки каждой ячейки массива
     */
    @Override
    public void display() {
        System.out.println("----------------------");
        for (int i = 0; i < data.length; i++) {
            Item<K, V> item = data[i];
            while (item != null) {
                System.out.printf("%d = [%s]%n", i, item);
                item = item.getNextItem();
            }
        }
        System.out.println("----------------------");
    }
}

