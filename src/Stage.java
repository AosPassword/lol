
import java.util.Random;

/**
 * @Author zhang
 * @Date 2017/11/9 15:55
 * @Content 对战舞台类
 */
public class Stage {
    //盖伦的武器名字
    public String garenWeaponName[] = {"风暴之剑","冰锤","海克斯手枪","饮血剑","反甲"};
    //盖伦的武器攻击力
    public int garenWeaponAttack[] = {30,20,24,25,0};
    public int garenWeaponDEF[]={10,10,10,10,80};

    //提莫的武器名字
    public String timoWeaponName[] = {"电刀","饮血剑","破败王者","杀戮之剑","三相之力"};
    //提莫的武器攻击力
    public int timoWeaponAttack[] = {32,30,27,35,15};
    public int timoWeaponDEF[]={2,2,5,0,15};

    public void startWar(Garen garen,TIMO timo) {
        System.out.println("盖伦加入战场，他的初始血量为："+garen.getHP()+"初始攻击为："+garen.getAttack()+"初始防御为："+garen.getDEF());
        System.out.println("提莫加入战场，他的初始血量为："+timo.getHP()+"初始攻击为："+timo.getAttack()+"初始防御为："+timo.getDEF());
        System.out.println("---战斗开始----");
        while(true) {

            //如果有任何一个英雄血量<=0 游戏结束
            if(garen.getHP() <=0 || timo.getHP() <=0){
                if(garen.getHP() <=0){
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                }else{
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }
            //这是属于盖伦的武器
            Weapon garenWeapon = new Weapon();
            //java中的随机数类
            Random garenRandom = new Random(System.currentTimeMillis());
            //随机0-3的一个整数出来
            int garenNumber = garenRandom.nextInt(5);
            //给盖伦的武器设置名字和攻击力
            garenWeapon.setWeaponAttact(garenWeaponAttack[garenNumber]);
            garenWeapon.setWeaponName(garenWeaponName[garenNumber]);
            garenWeapon.setWeaponDEF(garenWeaponDEF[garenNumber]);

            //实例化武器类 并且赋值给一个叫 timoWeapon的引用
            //这是属于提莫的武器
            Weapon timoWeapon = new Weapon();
            Random timoRandon = new Random(System.currentTimeMillis());
            int timoNumber = timoRandon.nextInt(5);
            timoWeapon.setWeaponName(timoWeaponName[timoNumber]);
            timoWeapon.setWeaponAttact(timoWeaponAttack[timoNumber]);
            timoWeapon.setWeaponDEF(timoWeaponDEF[timoNumber]);
            //盖伦有五种状态 获取武器 攻击提莫 什么也不做 英勇打击 审判
            Random garenAction = new Random();
            int num1 = garenAction.nextInt(5) + 1;
            switch(num1){
                case 1 :
                    garen.attack(timo);
                    break;
                case 2 :
                    garen.getWeapon(garenWeapon);
                    break;
                case 3 :
                    garen.Q(timo);
                    break;
                case 4 :
                    garen.shenpan(timo);
                    break;
                default :
                    System.out.println(garen.getName() + "什么也没做");
                    break;
            }
            if (garen.getQjinengshijian()!=0){
                int shengyuzhimangshijian;
                shengyuzhimangshijian=garen.getQjinengshijian()-1;
                garen.setQjinengshijian(shengyuzhimangshijian);
                System.out.println(garen.getName()+"剩余被致盲时间："+garen.getQjinengshijian());
            }
            if (timo.getBuff()!=0){
                int shenpandiaoxue,jianshao,shenpanshanghai=40;
                shenpandiaoxue=timo.getHP()-shenpanshanghai;
                timo.setHP(shenpandiaoxue);
                System.out.println(timo.getName()+"因为审判而失去了"+shenpanshanghai+"点生命值，他的剩余生命值为："+timo.getHP());
                jianshao=timo.getBuff()-1;
                timo.setBuff(jianshao);
                System.out.println(garen.getName()+"的剩余审判时间为："+timo.getBuff());
            }
            //如果有任何一个英雄血量<=0 游戏结束
            if(garen.getHP() <=0 || timo.getHP() <=0){
                if(garen.getHP() <=0){
                    System.out.println(timo.getName() + "战胜了" + garen.getName());
                }else{
                    System.out.println(garen.getName() + "战胜了" + timo.getName());
                }
                break;
            }


            //提莫也有六种状态 获取武器 攻击盖伦 嘲讽盖伦 什么也不做 毒性射击 小莫飞刀
            Random timoAction = new Random();
            int num2 = timoAction.nextInt(6) + 1;
            switch(num2){
                case 1 :
                    timo.attack(garen);
                    break;
                case 2 :
                    timo.getWeapon(timoWeapon);
                    break;
                case 3 :
                    timo.chaofeng(garen);
                    break;
                case 4 :
                    timo.zhongdu(garen);
                    break;
                case 5:
                    timo.Qjineng(garen);
                default :
                    System.out.println(timo.getName() + "什么也没有做");
                    break;
            }
            if (garen.getBuff()!=0){
                int zhongdudiaoxue,shijianjianshao,dushang=80;
                zhongdudiaoxue=garen.getHP()-dushang;
                garen.setHP(zhongdudiaoxue);
                System.out.println(garen.getName()+"因为中毒而失去了"+dushang+"点生命值，他的剩余生命值为："+garen.getHP());
                shijianjianshao=garen.getBuff()-1;
                garen.setBuff(shijianjianshao);
                System.out.println(garen.getName()+"的剩余中毒时间为："+garen.getBuff());
            }

        }

    }

    public static void main(String[] args) {
        //实例化一个盖伦
        Garen garen = new Garen();
        garen.setName("gay伦");
        garen.setAttack(50);
        garen.setHP(1000);
        garen.setDEF(0);
        garen.setBuff(0);
        //实例化一个提莫
        TIMO timo = new TIMO();
        timo.setName("提莫");
        timo.setHP(800);
        timo.setAttack(80);
        timo.setDEF(0);
        timo.setBuff(0);
        //实例化一个对战舞台 调用打架方法
        Stage stage = new Stage();
        stage.startWar(garen,timo);
    }
}
