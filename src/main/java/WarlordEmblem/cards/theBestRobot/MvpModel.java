package WarlordEmblem.cards.theBestRobot;

import WarlordEmblem.enums.CardEnum;
import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cc
 */
public class MvpModel extends CustomCard {
    public static final String ID = CardEnum.MVP_MODEL.getId();
    private static final String NAME = CardEnum.MVP_MODEL.getName();
    private static final int COST = CardEnum.MVP_MODEL.getCost();
    public static final String IMG_PATH = CardEnum.MVP_MODEL.getPath();
    private static final String DESCRIPTION = CardEnum.MVP_MODEL.getDesc();
    private static final CardType TYPE =CardEnum.MVP_MODEL.getType();
    private static final CardColor COLOR = CardEnum.MVP_MODEL.getColor();
    private static final CardRarity RARITY = CardEnum.MVP_MODEL.getRarity();
    private static final CardTarget TARGET = CardEnum.MVP_MODEL.getTarget();

    public MvpModel() {
        super(ID, NAME, IMG_PATH, COST, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);

    }
    @Override
    public void upgrade() {
        if (!this.upgraded) {

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

    }

}
