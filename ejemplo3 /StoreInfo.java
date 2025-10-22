public class StoreInfo {

    private String storeName;
    private String ownerName;
    private String email;
    private String description;

    public StoreInfo(String storeName, String ownerName, String email, String description) {
        this.storeName = storeName;
        this.ownerName = ownerName;
        this.email = email;
        this.description = description;
    }

    public void showInfo() {
        System.out.println("========================================");
        System.out.println("🏪 Tienda: " + storeName);
        System.out.println("👤 Propietario: " + ownerName);
        System.out.println("📧 Correo: " + email);
        System.out.println("💬 Descripción: " + description);
        System.out.println("========================================\n");
    }
}