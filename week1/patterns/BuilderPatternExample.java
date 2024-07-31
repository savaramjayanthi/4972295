
public class BuilderPatternExample {

    public static void main(String[] args) {
        
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                                    .setStorage("1TB SSD")
                                    .setGraphicsCard("NVIDIA RTX 3080")
                                    .build();

        Computer officePC = new Computer.Builder("Intel i5", "16GB")
                                    .setStorage("512GB SSD")
                                    .build();

        System.out.println(gamingPC);
        System.out.println(officePC);
    }
}

class Computer {
  
    private String CPU;
    private String RAM;
 
    private String storage;
    private String graphicsCard;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    
    public static class Builder {
       
        private String CPU;
        private String RAM;

      
        private String storage;
        private String graphicsCard;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GraphicsCard=" + graphicsCard + "]";
    }
}
