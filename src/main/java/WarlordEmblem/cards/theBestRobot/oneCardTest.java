package WarlordEmblem.cards.theBestRobot;

import WarlordEmblem.WarlordEmblem;
import WarlordEmblem.helpers.CardNameHelper;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * @author cc
 */
public class oneCardTest extends CustomCard {
    public static final String ID = CardNameHelper.makePath("thenIAskYou");
    private static final String NAME = "那我问你";
//    private static final String IMG_PATH = "src/main/resources/WarlordEmblem/img/cards/Kael/Kael_chaos_failing_stone.png";
    private static final int COST = 0;
    public static final String IMG_PATH = WarlordEmblem.assetPath("img/cards/Quest/quest_card_hunter.png");
    private static final String DESCRIPTION = "对敌方全体造成3点伤害，抽取一张牌，如果抽到回答我！,费用+1";
    private static final CardType TYPE = CardType.ATTACK;
    private static final CardColor COLOR = CardColor.BLUE;
    private static final CardRarity RARITY = CardRarity.BASIC;
    private static final CardTarget TARGET = CardTarget.ALL_ENEMY;
    public oneCardTest() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 6;
    }

    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName(); // 卡牌名字变为绿色并添加“+”，且标为升级过的卡牌，之后不能再升级。
            this.upgradeDamage(3); // 将该卡牌的伤害提高3点。
        }
    }

    /**
     * 当卡牌被使用时，调用这个方法。
     *
     * @param p 你的玩家实体类。
     * @param m 指向的怪物类。（无指向时为null，包括攻击所有敌人时）
     */
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(
                        m,
                        new DamageInfo(
                                p,
                                damage,
                                DamageInfo.DamageType.NORMAL
                        )
                )
        );
    }

}
