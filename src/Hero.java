
/**
 * @Author zhang
 * @Date 2017/11/9 15:28
 * @Content 英雄类（他是一个父类）
 */
public class Hero {

    private String name;//英雄名字
    private int HP;//英雄血量
    private int attack;//英雄攻击力
    private int DEF;//英雄防御力
    private int buff;//暂定一个中毒状态
    private int qjinengshijian;
    // -------------我们课上讲的封装 start----------
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getDEF(){return DEF;}

    public void setDEF(int DEF){this.DEF=DEF;}

    public int getBuff(){return buff;}

    public void setBuff(int buff){this.buff=buff;}

    public int getQjinengshijian(){return qjinengshijian   ;}

    public void setQjinengshijian(int qjinengshijian){this.qjinengshijian=qjinengshijian;}

    //----------封装 end------------------------------


   //获取武器
    public void getWeapon(Weapon weapon){
        //先获取自己当前的攻击力
        int selfAttack = getAttack();
        int selfDEF=getDEF();
        //讲准备提升的攻击力加到当前自己攻击力上
        selfAttack += weapon.getWeaponAttact();
        selfDEF+=weapon.getWeaponDEF();
        setAttack(selfAttack);
        setDEF(selfDEF);
        //把提升攻击力的这个过程打印出来
        System.out.println(this.getName() + "获得了" + weapon.getWeaponName() + "，攻击力提升了" + weapon.getWeaponAttact() +"防御力提升了"+weapon.getWeaponDEF()+ "此时攻击力为" + this.getAttack()+"此时防御力为"+this.getDEF());
    }

}

