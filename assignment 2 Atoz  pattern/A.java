class A {
    public void demo() {
        int a = 2;
        int b = 5; 
        int result = 1;

        for (int i = 1; i <= b; i++) {
          result =result* a;
        }

        System.out.println(a + " ^ " + b + " = " + result);
    }

    public static void main(String[] args) {
        A obj = new A();
        obj.demo();
    }
}
