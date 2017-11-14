import java.util.Random;

/**
 * @Author zhang
 * @Date 2017/11/9 15:51
 * @Content
 */
public class TIMO extends Hero{
    public void attack(Garen garen){
        int anotherHeroLeftHP = 0;
        //提莫拿自己的攻击力去攻击传入的garen
        Random suiji=new Random();
        int sui=suiji.nextInt(3);
        if (getAttack() <= garen.getDEF()) {
            System.out.println("提莫攻击了盖伦但是无奈他没出攻击装而且盖伦出了肉");
        }else if(getAttack()-garen.getDEF() <= garen.getHP()&&sui!=2){
            //如果提莫攻击力比盖伦的血量还低 说明这次攻击不足以击杀对方
            //我们就把盖伦的HP减去  减去的值应该是提莫当前的攻击力
            anotherHeroLeftHP = garen.getHP() - getAttack()+garen.getDEF();
            //然后把被攻击的英雄还剩下的血量设置回去
            garen.setHP(anotherHeroLeftHP);
            System.out.println(this.getName() + "攻击了" + garen.getName() + "," + garen.getName() + "HP还剩" + garen.getHP());
        }else if (getAttack()-garen.getDEF() <= garen.getHP()){
            anotherHeroLeftHP = garen.getHP() - getAttack()*2+garen.getDEF();
            garen.setHP(anotherHeroLeftHP);
            System.out.println(this.getName() + "爆击了" + garen.getName() + ",造成了双倍伤害，" + garen.getName() + "HP还剩" + garen.getHP());
        }
        else{
            //如果提莫的攻击力 比garen的血量还高 那garen就死了 游戏就结束了
            //被攻击的英雄血量设置为0
            garen.setHP(0);
            System.out.println(this.getName() + "攻击了" + garen.getName() + "," + garen.getName() + "HP还剩0");
        }
    }

    //提莫种蘑菇的方法
    public void chaofeng(Garen garen){
        int anotherHeroLeftDEF;
        int debuff=80;
        anotherHeroLeftDEF=garen.getDEF()-debuff;
        garen.setDEF(anotherHeroLeftDEF);
        System.out.println("提莫嘲讽了对面的大傻子并降低对方防御力80，对面剩余防御力为"+garen.getDEF());

    }
    public void zhongdu(Garen garen){
        int bufftime;
        bufftime=garen.getBuff()+3;
        garen.setBuff(bufftime);
        System.out.println("提莫使用了毒性射击让"+garen.getName()+"中毒，剩余中毒时间："+garen.getBuff());
    }
    public void Qjineng(Garen garen){
        int zhimangtime,suoshengshengming,jisnengshanghai=100;
        suoshengshengming=garen.getHP()-jisnengshanghai;
        garen.setHP(suoshengshengming);
        zhimangtime=garen.getQjinengshijian()+2;
        garen.setQjinengshijian(zhimangtime);
        System.out.println(getName()+"使用了小莫飞刀让"+garen.getName()+"致盲,并对其造成"+jisnengshanghai+"点伤害，剩余致盲时间"+garen.getQjinengshijian()+"，"+garen.getName()+"剩余生命值为"+garen.getHP());
    }
    //你可以为提莫添加其他有意思的方法 但是记得在调用的时候打印出来
}
