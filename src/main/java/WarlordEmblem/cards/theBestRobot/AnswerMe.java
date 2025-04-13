package WarlordEmblem.cards.theBestRobot;

import WarlordEmblem.enums.CardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
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
public class AnswerMe extends CustomCard {
    public static final String ID = CardEnum.HUI_DA_WO.getId();
    private static final String NAME = CardEnum.HUI_DA_WO.getName();
    //    private static final String IMG_PATH = "src/main/resources/WarlordEmblem/img/cards/Kael/Kael_chaos_failing_stone.png";
    private static final int COST = CardEnum.HUI_DA_WO.getCost();
    public static final String IMG_PATH = CardEnum.HUI_DA_WO.getPath();
    private static final String DESCRIPTION = CardEnum.HUI_DA_WO.getDesc();
    private static final CardType TYPE =CardEnum.HUI_DA_WO.getType();
    private static final CardColor COLOR = CardEnum.HUI_DA_WO.getColor();
    private static final CardRarity RARITY = CardEnum.HUI_DA_WO.getRarity();
    private static final CardTarget TARGET = CardEnum.HUI_DA_WO.getTarget();
    private static final Logger log = LoggerFactory.getLogger(AnswerMe.class);

    public AnswerMe() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.block = this.baseBlock = 3;
    }
    @Override
    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName(); // 卡牌名字变为绿色并添加“+”，且标为升级过的卡牌，之后不能再升级。
            this.upgradeBlock(3);
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
        AbstractDungeon.actionManager.addToBottom(new GainBlockAction(p, p, this.block));
        // 抽一张牌
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
