<template>
  <el-container style=" height: 500px; width:100% ;border: 1px solid #efe0b0; border-radius: 12px">
    <el-header style="height: 130px">
      <div>
        <div style="text-align: center; font-size: 28px;color:#1d58bf">
          <span>个人信息-学生信息</span>
        </div>

        <el-divider></el-divider>
        <el-divider></el-divider>
        <div style="text-align: center; font-size: 24px; font-weight:bold; color:#000000">
          <span>学生学籍信息</span>
        </div>
      </div>
    </el-header>

    <el-main>
      <table class="table listTable" >
        <tbody>
        <tr class="alt">
          <th width="10%" class="i18n" name="studentID">学号</th>
          <th width="23%" class="i19n">{{studentInfo.id}}</th>
          <th width="10%" class="i18n" name="name">姓名</th>
          <th width="23%" class="i19n">{{studentInfo.name}}</th>
          <th width="10%" class="i18n" name="gender">性别</th>
          <th width="24%" class="i19n">{{studentInfo.sex}}</th>
        </tr>

        <tr class="alt">
          <th width="10%" class="i18n" name="studentID">身份证号</th>
          <th width="23%" class="i19n">{{studentInfo.idCard}}</th>
          <th width="10%" class="i18n" name="name">民族</th>
          <th width="23%" class="i19n">{{studentInfo.nation}}</th>
          <th width="10%" class="i18n" name="gender">籍贯</th>
          <th width="24%" class="i19n">{{studentInfo.nativePlace}}</th>
        </tr>

        <tr class="alt">
          <th width="10%" class="i18n" name="studentID">出生日期</th>
          <th width="23%" class="i19n">{{studentInfo.birth}}</th>
          <th width="10%" class="i18n" name="name">政治面貌</th>
          <th width="23%" class="i19n">{{studentInfo.politicsStatus}}</th>
          <th width="10%" class="i18n" name="gender">院系</th>
          <th width="24%" class="i19n">{{studentInfo.academy.name}}</th>
        </tr>

        <tr class="alt">
          <th width="10%" class="i18n" name="studentID">专业</th>
          <th width="23%" class="i19n">{{studentInfo.major.name}}</th>
          <th width="10%" class="i18n" name="name">年级</th>
          <th width="23%" class="i19n">{{studentInfo.grade}}</th>
          <th width="10%" class="i18n" name="gender">电话号码</th>
          <th width="24%" class="i19n">{{studentInfo.phoneNum}}</th>
        </tr>

        </tbody>
      </table>
    </el-main>
  </el-container>

</template>

<script>
  export default {
    name: 'AStudentInfo',
    data() {
      return {
        id:'',
        studentInfo: {
          id:'',
          name:'',
          sex:'',
          idCard:'',
          nation:'',
          nativePlace:'',
          birth:'',
          politicsStatus:'',
          academy:{id:'', name:''},
          major:{id:'', name:''},
          grade:'',
          phoneNum:''
        }
      }
    },

    created() {
      this.initStudentId();
      this.initStudentInfos();
    },


    methods: {
      initStudentInfos () {
        this.$axios.post('/api/studentInfo/findStudentDetailsById', {
          id: this.id,
        }).then(res => {
          this.studentInfo = res.data;
        })
      },
      initStudentId(){
        this.id=this.$route.query.id;
      },


    }


  }
</script>

<style scoped>

  .el-divider{
    margin: 5px 0;
    background: 0 0;
    border-top: 1px solid #000000;
  }
  .table {
    width: 100%;
    border-collapse: collapse;
    background-color: #b1b4b4;
    text-align: center;
    font-size: 18px;
  }
  .listTable {
    text-align: center;
    border-collapse: collapse;
    margin-top: 10px;
    border: 1px solid #494848;
    color: #000;

  }
  .alt {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
  }
  .i18n {
    display: table-cell;
    vertical-align: inherit;
    font-weight: bold;
    font-size: 18px;
    background-color: #94afaf;
    text-align: center;
    border: 1px solid #494848;
    height: 40px;
    padding-top: 5px;
    padding-bottom: 5px;
    font-family: "Microsoft YaHei",Arial,Helvetica,sans-serif;
  }
  .i19n {
    font-weight: normal;
    border: 1px solid #494848;
    font-size: 18px;
    height: 40px;
    padding-top: 5px;
    padding-bottom: 5px;
    font-family: "Microsoft YaHei",Arial,Helvetica,sans-serif;
  }
</style>
