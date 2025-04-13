package WarlordEmblem.enums;

import com.megacrit.cardcrawl.cards.AbstractCard;
import lombok.Getter;

import static WarlordEmblem.WarlordEmblem.MOD_ID;

@Getter
public enum CardEnum {
    NA_WO_WEN_NI(
            "那我问你",
            "对敌方全体造成!D!点伤害，抽取一张牌，如果抽到”回答我“,当前可用费用+1",
            "thenIAskYou",
            1,
            "img/cards/Quest/quest_card_hunter_reward.png",
            AbstractCard.CardType.ATTACK,
            AbstractCard.CardColor.BLUE,
            AbstractCard.CardRarity.BASIC,
            AbstractCard.CardTarget.ALL_ENEMY
    ),
    HUI_DA_WO(
            "回答我！",
            "获得!B!点格挡，抽取一张牌，如果抽到“那我问你，当前可用费用+1",
            "answerMe",
            1,
            "img/cards/Quest/quest_card_hunter_reward.png",
            AbstractCard.CardType.SKILL,
            AbstractCard.CardColor.BLUE,
            AbstractCard.CardRarity.BASIC,
            AbstractCard.CardTarget.NONE

    )
    ;
    private final String id;
    private final String name;
    private final String desc;
    private final Integer cost;
    private final String path;
    private final AbstractCard.CardType type;
    private final AbstractCard.CardColor color;
    private final AbstractCard.CardRarity rarity ;
    private final AbstractCard.CardTarget target;


    CardEnum(String name, String desc, String id, Integer cost, String path, AbstractCard.CardType type, AbstractCard.CardColor color, AbstractCard.CardRarity rarity, AbstractCard.CardTarget target) {
        this.id = "XiaoMing" + id;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
        this.path = MOD_ID + "/" + path;
        this.type = type;
        this.color = color;
        this.rarity = rarity;
        this.target = target;
    }
}
