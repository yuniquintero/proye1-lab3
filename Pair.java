public class Pair<F, S>{
	public final F f;
	public final S s;

    public Pair( F f, S s ) {
        this.f = f;
        this.s = s;
    }

    public F getFirst() {
        return f;
    }

    public S getSecond() {
        return s;
    }
}