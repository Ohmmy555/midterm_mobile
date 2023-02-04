// DataClass

class MemberData(val Name:String, val Os:String, val Type:String, val Date: String,val Month:Int):
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeString(Os)
        parcel.writeString(Type)
        parcel.writeString(Date)
        parcel.writeInt(Month)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MemberData> {
        override fun createFromParcel(parcel: Parcel): MemberData {
            return MemberData(parcel)
        }

        override fun newArray(size: Int): Array<MemberData?> {
            return arrayOfNulls(size)
        }
    }
}