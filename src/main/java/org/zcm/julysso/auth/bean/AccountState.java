package org.zcm.julysso.auth.bean;

/**
 * Account State
 * @author Bruce Zhong
 */
public enum AccountState {
    STATE_INACTIVE(0),
    STATE_ACTIVE(1),
    STATE_LOCKED(2),
    STATE_FROZEN(3),
    STATE_DELETE(4);

    private final int value;
    AccountState(int value){
        this.value = value;
    }

    public static AccountState valueOf(int value) {
        switch (value) {
            case 0: return AccountState.STATE_INACTIVE;
            case 1: return AccountState.STATE_ACTIVE;
            case 2: return AccountState.STATE_LOCKED;
            case 3: return AccountState.STATE_FROZEN;
            case 4: return AccountState.STATE_DELETE;
            default: return null;
        }
    }

}
