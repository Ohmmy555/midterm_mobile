class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    // ตัวแปรสำหรับเก็บค่าจาก RadioButton
    var membertype : String =""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ทำ Dropdown
        val sub = resources.getStringArray(R.array.Memberprice)
        val arrAdapter = ArrayAdapter(this,R.layout.dropdown_item,sub)
        binding.type.setAdapter(arrAdapter)
        binding.type.setOnItemClickListener{parent, _, posistion, _ ->
            membertype = parent.getItemAtPosition(posistion) as String
        }
    }
    // ฟังก์ชันปุ่ม Submit
    fun SUBMIT(view: View) {
        var name = binding.Name.text.toString()
        var DateRegister = binding.Date.text.toString()
        var NumberOfMonth = binding.Month.text.toString()
        if(name.equals("")&&NumberOfMonth.equals("")&&DateRegister.equals("")){
            Toast.makeText(applicationContext,"Please Enter Fill",Toast.LENGTH_LONG).show()
        }else{
            var idSelected : Int = binding.RadioGroup.checkedRadioButtonId
            var RadioSelected : RadioButton = findViewById(idSelected)
            val indent = Intent(this,SecondActivity::class.java)
            indent.putExtra("Member",MemberData(name.toString(),RadioSelected.text.toString(),membertype,DateRegister,NumberOfMonth.toInt()))
            startActivity(indent)
        }
    }
    // ฟังก์ชันปุ่ม Reset
    fun RESET(view: View) {
        binding.Name.text?.clear()
        binding.RadioGroup.clearCheck()
        binding.type.setText("SELECT")
        binding.type.clearFocus()
        val sub = resources.getStringArray(R.array.Memberprice)
        val arrAdapter = ArrayAdapter(this,R.layout.dropdown_item,sub)
        binding.type.setAdapter(arrAdapter)
        binding.Date.text?.clear()
        binding.Month.text?.clear()
    }

}