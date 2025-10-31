public interface SelectableSlime {
    void onSelected();    // slime di tengah → animasi Dance + scale 40%
    void onDeselected();  // slime di kiri/kanan → animasi Idle + scale normal
}
