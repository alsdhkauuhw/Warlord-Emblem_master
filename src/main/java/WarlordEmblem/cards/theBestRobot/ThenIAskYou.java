package WarlordEmblem.cards.theBestRobot;

import WarlordEmblem.enums.CardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cc
 */
public class ThenIAskYou extends CustomCard {
    public static final String ID = CardEnum.NA_WO_WEN_NI.getId();
    private static final String NAME = CardEnum.NA_WO_WEN_NI.getName();
//    private static final String IMG_PATH = "src/main/resources/WarlordEmblem/img/cards/Kael/Kael_chaos_failing_stone.png";
    private static final int COST = CardEnum.NA_WO_WEN_NI.getCost();
    public static final String IMG_PATH = CardEnum.NA_WO_WEN_NI.getPath();
    private static final String DESCRIPTION = CardEnum.NA_WO_WEN_NI.getDesc();
    private static final CardType TYPE =CardEnum.NA_WO_WEN_NI.getType();
    private static final CardColor COLOR = CardEnum.NA_WO_WEN_NI.getColor();
    private static final CardRarity RARITY = CardEnum.NA_WO_WEN_NI.getRarity();
    private static final CardTarget TARGET = CardEnum.NA_WO_WEN_NI.getTarget();
    private static final Logger log = LoggerFactory.getLogger(ThenIAskYou.class);

    public ThenIAskYou() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.damage = this.baseDamage = 3;
        this.tags.add(CardTags.STARTER_STRIKE);
        this.tags.add(CardTags.STRIKE);
    }
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName(); // 卡牌名字变为绿色并添加“+”，且标为升级过的卡牌，之后不能再升级。
            this.upgradeDamage(3);
            // 将该卡牌的伤害提高3点。
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
        // 对所有敌人造成伤害
        for (AbstractMonster mo : AbstractDungeon.getCurrRoom().monsters.monsters) {
            if (!mo.isDeadOrEscaped()) {
                AbstractDungeon.actionManager.addToBottom(
                        new DamageAction(
                                mo,
                                new DamageInfo(p, this.damage, DamageInfo.DamageType.NORMAL),
                                AbstractGameAction.AttackEffect.SLASH_HORIZONTAL
                        )
                );
            }
        }

        // 抽一张牌，并判断是否是 “那我问你”，如果是则获得 1 点能量
        AbstractDungeon.actionManager.addToBottom(new DrawCardAction(1, new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard card : DrawCardAction.drawnCards) {
                    if (CardEnum.NA_WO_WEN_NI.getId().equals(card.cardID)) {
                        AbstractDungeon.actionManager.addToTop(new GainEnergyAction(1));
                        log.info("抽到了 那我问你，增加1点能量！");
                    }
                }
                this.isDone = true;
            }
        }));
    }


}
