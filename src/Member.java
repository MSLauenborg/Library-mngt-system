import java.util.ArrayList;

public class Member {

    final String memberName;
    final int memberId;


    public Member(String memberName, int memberId) {
        this.memberName = memberName;
        this.memberId = memberId;

    }

    public int getMemberId() {
        return this.memberId;
    }


    public String toString() {
        return String.format("Medlemsnavn: %s, ID: %s", memberName, memberId);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Member)) {
            return false;
        }
        Member other = (Member) obj;
        return this.memberName.equals(other.memberName);
    }

}
