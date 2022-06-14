<template>
  <div>
    <div id="select_id" style="width: 350px ;display: flex;margin-top: 10px;margin-left: 10px">
      <el-input placeholder="请输入内容" prefix-icon="el-icon-search" v-model="param"></el-input>
      <el-button type="primary" style="margin-left: 10px" @click="local"> 搜索</el-button>
    </div>
    <!--    按钮区-->
    <div style="margin-left: 10px ; margin-top: 10px">
      <el-button type="primary" @click="dialogVisible= true">新增</el-button>
    </div>
    <div style="margin: 10px">
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="snum" label="学号" width="160"></el-table-column>
        <el-table-column prop="sname" label="姓名" width="130"></el-table-column>
        <el-table-column prop="sclass" label="班级" width="130"></el-table-column>
        <el-table-column prop="sgrade" label="专业" width="180"></el-table-column>
        <el-table-column prop="stelephone" label="联系电话" width="180"></el-table-column>
        <el-table-column prop="dnum" label="宿舍号" width="120"></el-table-column>
        <el-table-column align="left" label="操作" width="160">
          <template #default="scope">
            <el-button size="mini" type="primary" @click="handleEdit(scope.row)">修改</el-button>
            <el-popconfirm title="确定删除吗？" @confirm="handleDelete(scope.row)">
              <template #reference>
                <el-button style="margin-left: 10px" size="mini" type="danger">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>

      <el-dialog title="弹窗" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <el-form ref="form" v-model="from" label-width="80px">

          <el-form-item label="学号">
            <el-input v-model="from.snum"></el-input>
          </el-form-item>

          <el-form-item label="姓名">
            <el-input v-model="from.sname"></el-input>
          </el-form-item>

          <el-form-item label="班级">
            <el-input v-model="from.sclass"></el-input>
          </el-form-item>

          <el-form-item label="电话">
            <el-input v-model="from.stelephone"></el-input>
          </el-form-item>

          <el-form-item label="专业">
            <el-input v-model="from.sgrade"></el-input>
          </el-form-item>


          <el-form-item label="宿舍号">
            <el-input v-model="from.did"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save(); dialogVisible=false ">确 定</el-button>
  </span>
      </el-dialog>

    </div>
  </div>
</template>

<script>
import request from "@/until";

export default {
  name: "StudentInfo",
  data() {
    return {
      param: '',
      tableData: [],
      dialogVisible: false,
      from: {
        id: '',
        snum: '',
        sname: '',
        sclass: '',
        sgrade: '',
        stelephone: '',
        did: '',
        dnum: '',
      }
    }
  },
  created() {
    this.local();
  },
  methods: {
    handleClose(done) {
      done();
      this.dialogVisible = false
    },
    local() {
      request.get("/api/student/search", {
        params: {
          param: this.param,
        }
      }).then(res => {
        this.tableData = res.data
      })
    },
    /*更新或者修改*/
    save() {
      if (this.from.id) {//更新
        request.put("/api/student/update", this.from).then(res => {
          this.local();
          console.log("刷新完成")
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "更新成功"
            })
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      } else {// 添加
        request.post("/api/student/add", this.from).then(res => {
          console.log(res)
          this.local();
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "添加成功"
            })

          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }
      this.dialogVisible=false


      this.from={}
    },

    handleEdit(row) {
      let temp=JSON.parse(JSON.stringify(row))
      this.from = temp
      this.dialogVisible = true;
    },

    handleDelete(row) {
      request.delete("/api/student/delete/" + row.id).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          this.local();
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          })
        }
      })
    },
  }
}
</script>

<style scoped>

</style>
