class SecondActivity : AppCompatActivity() {
    private lateinit var bindingSecond : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSecond = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bindingSecond.root)

        // รับค่าจากอีกหน้า
        var data = intent.extras
        var member:MemberData? = data?.getParcelable("Member")


        // กำหนดค่าลงหน้าที่สอง
        bindingSecond.tvName.text = " ${member?.Name}"
        bindingSecond.tvOs.text = " ${member?.Os}"
        bindingSecond.tvType.text = " ${member?.Type} Bath"
        bindingSecond.tvDate.text = " ${member?.Date}"
        bindingSecond.tvMonth.text = " ${member?.Month}"
        bindingSecond.tvPrice.text = " ${member?.Type.toString().toInt()!! * member?.Month.toString().toInt()} Baht"



    }

    fun Close(view: View) {
        finish()
    }
}