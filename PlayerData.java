public class PlayerData {
    private static int selectedSlime = 1; // default slime tengah

    public static void setSelectedSlime(int index) {
        selectedSlime = index;
    }

    public static int getSelectedSlime() {
        return selectedSlime;
    }
}
