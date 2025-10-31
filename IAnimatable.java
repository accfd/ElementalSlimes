/**
 * IAnimatable - interface sederhana untuk actor yang punya animasi
 */
public interface IAnimatable {
    void playAnimation(String action); // e.g. "Idle", "Dance"
    void updateAnimation();            // dipanggil di act()
}
