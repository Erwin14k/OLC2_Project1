package Expression;


    public enum LiteralType {
        STRING  (0),
        INTEGER  (1),
        LOGICAL  (2),
        REAL (3),
        COMPLEX(4),
        ARRAY (5);


        private final int value;

        LiteralType(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }
    }

