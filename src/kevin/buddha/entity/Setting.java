package kevin.buddha.entity;

import java.io.Serializable;

public class Setting implements Serializable {

    private static final long serialVersionUID = 6402863661200772744L;

    /**
     * 是否已经选择过佛了，即是否已【请佛】
     */
    private boolean isSelectedBuddha;

    public boolean isSelectedBuddha() {
        return isSelectedBuddha;
    }

    public void setSelectedBuddha(boolean isSelectedBuddha) {
        this.isSelectedBuddha = isSelectedBuddha;
    }

}
