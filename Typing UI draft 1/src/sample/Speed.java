package sample;

public class Speed {
	public static void main(String[] Args) {
	}
	public static int speedCalc(int charactersTyped, int seconds) {
		int result = Math.round(((float)charactersTyped/((float)seconds / 60f))/4.5f);
		return result;
	}
}
