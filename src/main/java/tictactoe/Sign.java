package tictactoe;

public enum Sign {
    X{
        public Sign revers() {
            return O;
        }
    },

    O{
        public Sign revers() {
            return X;
        }
    };

    public abstract Sign revers();
}
