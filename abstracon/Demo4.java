// example showing the concept of abstract class 

abstract class bank{
    int noc = 100;  //no of customer
    abstract int transaction();
}
class hdfc  extends bank{
    @Override
    int  transaction(){
        return 90;
    }
}
class idfc extends bank{
    @Override
    int transaction(){
        return 85;
    }
}
class kotak extends bank{
    @Override
    int transaction(){
        return 50;
    }
}

class Demo4{
    public static void main(String args[]){
        bank obj;
        obj = new hdfc();
        System.out.println("no of customers daily transaction  : "+obj.transaction()+"\t"+obj.noc);
        obj = new idfc();
        System.out.println("no o customer daily transaction  : "+obj.transaction());
        obj = new kotak();
        System.out.println("no of customer daily transaction  : "+obj.transaction());
    }
}