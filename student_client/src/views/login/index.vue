<template>
  <div>
    <el-container>
      <el-header>
        <div style="text-align: center; font-size: 25px; font-weight: bolder">
          <i class="el-icon-s-home" style="margin-right: 25px"></i>
          选课管理系统
        </div>
      </el-header>
      <el-main>
        <el-card class="login-module">
          <div slot="header" class="clearfix">
            <span style="text-align: center; font-size: 20px; font-family: 'Microsoft YaHei'">
              <p><i class="el-icon-office-building" style="margin-right: 18px"></i>登陆</p>
            </span>
          </div>
          <div>
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
              <el-form-item label="用户邮箱" prop="email">
                <el-input v-model.number="ruleForm.email" prefix-icon="el-icon-lollipop"></el-input>
              </el-form-item>
              <el-form-item label="用户密码" prop="password">
                <el-input v-model="ruleForm.password" placeholder="请输入密码" show-password
                          prefix-icon="el-icon-ice-cream-round"></el-input>
              </el-form-item>
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">登陆</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </el-main>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      ruleForm: {
        email: '',
        password: ''
      },
      rules: {
        email: [
          {required: true, message: '请输入用户邮箱', trigger: 'change'},
          {type: 'email', message: '请输入有效的邮箱地址', trigger: 'change'},
        ],
        password: [
          {required: true, message: '请输入密码', trigger: 'blur'},
          {min: 6, max: 20, message: '密码长度在 6 到 20 个字符之间', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const that = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let check = false
          let name = null

          axios.get('http://localhost:10086/info/getCurrentTerm').then(resp => {
            that.$store.commit('setTerm', resp.data)
          })

          axios.get('http://localhost:10086/info/getForbidCourseSelection').then(function (resp) {
            sessionStorage.setItem("ForbidCourseSelection", resp.data)
          })

          let form1 = {email: that.ruleForm.email, password: that.ruleForm.password}
          console.log(form1)
          axios.post("http://localhost:10086/teacher/login", form1).then(function (resp) {
            console.log("教师登陆验证信息：" + resp.data)
            check = resp.data
            if (check === true) {
              axios.get("http://localhost:10086/teacher/findByEmail/" + that.ruleForm.email).then(function (resp) {
                console.log("登陆页正在获取用户信息" + resp.data)
                name = resp.data.tname

                sessionStorage.setItem("token", 'true')
                that.$store.commit('setName', name)
                sessionStorage.setItem("tid", resp.data.tid)
                console.log('name: ' + name + ' ' + that.ruleForm.email + ' ' + resp.data.tid)

                if (name === 'admin') {
                  sessionStorage.setItem("type", 'admin')
                  that.$message({
                    showClose: true,
                    message: '登陆成功，欢迎 ' + name + '!',
                    type: 'success'
                  });
                  that.$router.push('/admin')
                } else if (name !== 'admin') {
                  sessionStorage.setItem("type", 'teacher')
                  that.$message({
                    showClose: true,
                    message: '登陆成功，欢迎 ' + name + '!',
                    type: 'success'
                  });
                  that.$router.push('/teacher')
                }
              })
            }else {
              let form2 = {email: that.ruleForm.email, password: that.ruleForm.password}
              axios.post("http://localhost:10086/student/login", form2).then(function (resp) {
                console.log("学生登陆验证信息：" + resp.data)
                check = resp.data
                if (check === true) {

                  axios.get("http://localhost:10086/student/findByEmail/" + that.ruleForm.email).then(function (resp) {
                    console.log("登陆页正在获取用户信息" + resp.data)
                    name = resp.data.sname

                    sessionStorage.setItem("token", 'true')
                    sessionStorage.setItem("type", 'student')
                    sessionStorage.setItem("name", name)
                    sessionStorage.setItem("sid", resp.data.sid)

                    that.$message({
                      showClose: true,
                      message: '登陆成功，欢迎 ' + name + '!',
                      type: 'success'
                    });

                    console.log('正在跳转：' + '/' + that.ruleForm.type)

                    // 3. 路由跳转
                    that.$router.push({
                      path: '/' + that.ruleForm.type,
                      query: {}
                    })
                  })
                } else {
                    that.$message({
                      showClose: true,
                      message: '账号密码错误，请联系管理员',
                      type: 'error'
                    })
                }
              })
            }

          })
        } else {
          console.log('error submit!!');
          return false;
        }
      })

    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style>
.login-module {
  margin-top: 60px;
  position: absolute;
  right: 500px;
  text-align: center;
  width: 30%;
}

.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}
</style>