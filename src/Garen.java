import java.util.Random;

/**
 * @Author zhang
 * @Date 2017/11/9 15:31
 * @Content
 */
public class Garen extends Hero {
    public void attack(TIMO timo) {
        int anotherHeroLeftHP = 0;
        //盖伦拿自己的攻击力去攻击传入的timo
        Random random=new Random();
        int ran=random.nextInt(4);
        if (timo.getHP() <= 200) {
            timo.setHP(0);
            System.out.println("德玛西亚！\n" + this.getName() + "使用德玛西亚正义斩杀了" + timo.getName());
        } else if (getQjinengshijian()!=0){
            System.out.println(getName()+"尝试了攻击但是被致盲了，"+timo.getName()+"闪避了这次攻击");
        }
        else if (getAttack() <= timo.getDEF()) {
            System.out.println("盖伦攻击了提莫但是无奈他没出攻击装而且提莫出了肉");
        } else if (getAttack() - timo.getDEF() <= timo.getHP()&&ran!=3) {
            //如果盖伦攻击力比被timo的血量还低 说明这次攻击不足以击杀对方
            //我们就把提莫的HP减去  减去的值应该是盖伦的攻击力
            anotherHeroLeftHP = timo.getHP() - getAttack() + timo.getDEF();
            //然后把timo还剩下的血量设置回去
            timo.setHP(anotherHeroLeftHP);
            System.out.println(this.getName() + "攻击了" + timo.getName() + "," + timo.getName() + "HP还剩" + timo.getHP());
        } else if (getAttack() - timo.getDEF() <= timo.getHP()){
            anotherHeroLeftHP = timo.getHP() - getAttack()*2 + timo.getDEF();
            timo.setHP(anotherHeroLeftHP);
            System.out.println(this.getName() + "爆击了" + timo.getName() + ",造成双倍伤害，" + timo.getName() + "HP还剩" + timo.getHP());
        } else {
            //如果盖伦攻击力 比timo的血量还高 那timo就死了 游戏就结束了
            //被攻击的英雄血量设置为0
            timo.setHP(0);
            System.out.println(this.getName() + "攻击了" + timo.getName() + "," + timo.getName() + "HP还剩0");
        }
    }

    public void Q(TIMO timo) {
        int timolefthp = 0;
        double shanghai = 100 + (int) getAttack() * 1.3;
        int Shanghai = (int) shanghai;
        if (getQjinengshijian()!=0){
            System.out.println(getName()+"使用了英勇打击但是被致盲了，"+timo.getName()+"闪避了这次攻击");
        } else if (shanghai <= timo.getDEF()) {
            System.out.println("盖伦使用了英勇打击攻击了提莫但是无奈他没出攻击装而且对面出了肉，所以他白白的让了对面一个回合");
        } else if (shanghai - timo.getDEF() <= timo.getHP()) {
            timolefthp = timo.getHP() - Shanghai + timo.getDEF();
            timo.setHP(timolefthp);
            System.out.println(this.getName() + "使用英勇打击攻击了" + timo.getName() + "," + timo.getName() + "HP还剩" + timo.getHP());
        } else {
            timo.setHP(0);
            System.out.println(this.getName() + "攻击了" + timo.getName() + "," + timo.getName() + "HP还剩0");
        }
        //你可以为盖伦添加其他有意思的方法 但是记得在调用的时候打印出来
    }
    public void shenpan(TIMO timo){
        int bufftime;
        bufftime=timo.getBuff()+6;
        timo.setBuff(bufftime);
        System.out.println(this.getName()+"使用了审判让"+timo.getName()+"受到伤害，剩余持续时间时间："+timo.getBuff());
    }
}

