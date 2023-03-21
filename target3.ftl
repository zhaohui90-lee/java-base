{
  "root": {
    "head": {
      "trdate": "${rd.trdate}",
      "trtime": "${rd.trtime}",
      "trcode": "${sd.trcode}",
      "jdseq": "${sd.jdseq}",
      "device_no": "${sd.device_no}",
      "succflag": "${rd.successflag}",
      "retcode": "${rd.code}",
      "retmsg": "${rd.message}",
      "timeexec":"${timeexec.getDateAnalyze()}"
    },
    "body": {
      <#if rd.ActionResult == "true">
        "detail": [
          <#list rd.Table as detailList>
            {
            "department_no": "${detailList.KESHIBH}",
            "appointment_type": "${detailList.YUYUELX}",
            "appointment_date": "${detailList.YUYUESJ}",
            "doctor_id": "${detailList.YISHENGGH}",
            "visit_date": "${detailList.JIUZHENSJ}",
            "register_no": "${detailList.GUAHAOXH}",
            "patient_name": "${detailList.HUANZHEXM}",
            "dept_name": "${detailList.KESHIMC}",
            "doc_name": "${detailList.YISHENGXM}",
            "appointment_key": "${detailList.YUYUEJLZJ}",
            "duty_type": "${detailList.ZHIBAILB}"
            }<#if (detailList_index+1)!=(rd.Table?size)>,</#if>
          </#list>
        ]
      </#if>
    }
  }
}