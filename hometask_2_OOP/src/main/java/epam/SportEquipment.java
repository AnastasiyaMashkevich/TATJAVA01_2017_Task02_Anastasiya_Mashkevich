package epam;

public class SportEquipment {

    private Category category;
    private String title;
    private int price;

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public SportEquipment (Category category, String title, int price) {
        this.category=category;
        this.title=title;
        this.price=price;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (price != that.price) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

        }

