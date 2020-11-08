package uml;

/**
 * 设计一个 Sherry 类
 * @author Arvin
 * @date 2020/11/09
 *
 * 指定一个类成员（即任何属性或方法）的可见性有下列符号，必须摆在各成员的名字之前：
 *     +   公共
 *     -   私有
 *     #   保護（即對子類可見）
 *     ~   包（即對包内其他成員可見）
 *     /   推導（即由其他屬性推導得出，不需要直接給定其值）
 *    底線  靜態
 *
 */
public class Sherry {


    /**
     * Sherry 有自己的名字  （-）
     */
    private String name;

    /**
     * Sherry 有响亮的嗓音  （+）
     */
    public void barking(){}

    /**
     * Sherry 有大长腿      （#）
     */
    protected String longLegs;


    /**
     *  Sherry 跑的快 （ / ），因为Sherry 有大长腿。
     */
    public void runingFast(){}

    /**
     * Sherry 有一个家族的血统标记 （~），
     */
     public String familyBlood;


}
