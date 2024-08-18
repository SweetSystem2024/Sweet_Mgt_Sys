package myApp;

       public class Material {
	 
    	   
    	   
    	   
    	   

	private int materialId;
	    private String name;
	    private double price;
	    private int quantityavailable;
	    
	    
	    
	
		
		
		
		public Material(int materialId, String name, double price, int quantityavailable) {
			super();
			this.materialId = materialId;
			this.name = name;
			this.price = price;
			this.quantityavailable = quantityavailable;
		}
		public int getMaterialId() {
			return materialId;
		}
		public void setMaterialId(int materialId) {
			this.materialId = materialId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getQuantityavailable() {
			return quantityavailable;
		}
		public void setQuantityavailable(int quantityavailable) {
			this.quantityavailable = quantityavailable;
		}
		
	 	   @Override
	 		public String toString() {
	 			return "Material [materialId=" + materialId + ", name=" + name + ", price=" + price + ", quantityavailable="
	 					+ quantityavailable + "]";
	 		}
		
}
