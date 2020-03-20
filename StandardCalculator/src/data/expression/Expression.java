interface Expression {
    public boolean checkSymbol(String inputString);
    public float solve();

    @Override
    public String toString();
}