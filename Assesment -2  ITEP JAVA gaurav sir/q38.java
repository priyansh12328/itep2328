 class q38 {
    public static void main(String[] args) {
        int volume = 1287;
        int radius = 10;
        float height = volume/(3.14f*radius*radius);
        float surface_area = 2*3.14f*10*(height+radius);
        System.out.println("area : "+ surface_area);

    }

 }