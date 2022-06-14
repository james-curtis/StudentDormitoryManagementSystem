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
        <el-table-column prop="id" label="编号" width="120"></el-table-column>
        <el-table-column prop="ename" label="姓名" width="180"></el-table-column>
        <el-table-column prop="eposition" label="职位" width="180"></el-table-column>
        <el-table-column prop="ebname" label="所属楼" width="180">
        </el-table-column>
        <el-table-column prop="etelephone" label="联系电话" width="190"></el-table-column>
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
          <el-form-item label="姓名">
            <el-input v-model="from.ename"></el-input>
          </el-form-item>

          <el-form-item label="职位">
            <el-input v-model="from.eposition"></el-input>
          </el-form-item>
          <el-form-item label="所属楼">
            <el-input v-model="from.ebname"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="from.etelephone"></el-input>
          </el-form-item>

        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save(); dialogVisible = false">确 定</el-button>
  </span>
      </el-dialog>

    </div>
  </div>

</template>
<script>
import request from "@/until";

export default {
  name: "Employee",
  data() {
    return {
      dialogVisible: false,
      param: '',
      tableData: [],
      from: {
        id: '',
        ename: '',
        etelephone: '',
        ebname: '',
        eposition: '',
      }
    }
  },
  created() {
    this.local();
  },
  methods: {
    local() {
      request.get("/api/employee/searchWithParam", {
        params: {
          param: this.param
        }
      }).then(res => {
        if (res.code === '0') {
          console.log(res.data)
          this.tableData = res.data;
        }
      })
    },
    save() {
      if (this.from.id) {//更新
        request.put("/api/employee/updateEmployee", this.from).then(res => {
          this.local();
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
      } else {
        request.post("/api/employee/addEmployee", this.from).then(res => {
          // console.log(res)
          this.local();
          if (res.code === "0") {
            this.$message({
              type: "success",
              message: "添加成功"
            })
            // this.local();
          } else {
            this.$message({
              type: "error",
              message: res.msg
            })
          }
        })
      }

      this.dialogVisible = false
      this.from = {}

    },


    handleEdit(row) {
      console.log("员工", row)
      let temp = JSON.parse(JSON.stringify(row))
      this.from = temp

      this.dialogVisible = true;
      console.log("员工", this.from)

    },

    handleDelete(row) {
      request.delete("/api/employee/deleteEmployee/" + row.id).then(res => {
        if (res.code === "0") {
          this.$message({
            type: "success",
            message: "删除成功"
          })
          // eslint-disable-next-line no-undef
          this.local()
        } else {
          this.$message({
            type: "error",
            message: "删除失败"
          })
        }
      })
    },
    handleClose(done) {
      done();
      this.dialogVisible = false
    }

  }
}
</script>

<style scoped>

</style>
