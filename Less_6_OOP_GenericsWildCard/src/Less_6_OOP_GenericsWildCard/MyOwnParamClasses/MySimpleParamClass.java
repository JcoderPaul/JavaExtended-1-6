package Less_6_OOP_GenericsWildCard.MyOwnParamClasses;

public class MySimpleParamClass <T> {
        private T value;
        /*
        Естественно, что поле 'private T value' не может быть static т.к. принадлежность
        к классу, а не к объекту, не дала бы возможность оперировать ей при изменчивости
        хранителя типов.
        */
        public MySimpleParamClass(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + value + "}";
        }
}
