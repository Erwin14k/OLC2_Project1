package Expression;
    public enum ReturnType {

        INTEGER(0),
        REAL(1),
        CHARACTER(2),
        LOGICAL (3),
        COMPLEX(4),
        ARRAY (5);




        private final int value;

        ReturnType(final int newValue) {
            value = newValue;
        }

        public int getValue() {
            return value;
        }

        public static int [][] matrix={{ReturnType.INTEGER.getValue(),ReturnType.REAL.getValue()},
                {ReturnType.REAL.getValue(),ReturnType.REAL.getValue()}};

    }


