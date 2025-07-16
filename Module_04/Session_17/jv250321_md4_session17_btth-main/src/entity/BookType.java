package entity;

public class BookType {
    private int typeId;
    private String typeName;
    private String description;
    private boolean status;

    public BookType() {
    }

    public BookType(int typeId, String typeName, String description, boolean status) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Mã loại sách: %d - Tên loại sách: %s - Mô tả: %s - Trạng thái: %s",
                this.typeId, this.typeName, this.description, this.status ? "Hoạt động" : "Không hoạt động");
    }
}
