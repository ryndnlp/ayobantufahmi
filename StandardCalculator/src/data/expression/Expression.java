//package data.expression;
package data.expression;

public interface Expression<T extends Number> { // Why is Expression Generic? BECUASE SPEK! (And we couldn't find
                                                // another place to use generics....)
    public boolean checkSymbol(String inputString);

    public String getSymbol();

    public T solve() throws Exception;

    @Override
    public String toString();
}
