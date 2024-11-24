import axios from "axios";
export const createPatient = (id, name, sex, address, yearOfBirth,date)=> {
    return axios.post("/api/patient",{id, name, sex, address,yearOfBirth,date})

}
export const getPatients = ()=>{
    return axios.get("/api/patients");
}

export const getExaminationResults = (id) => {
    return axios.get("api/examinationResults/"+id)
}
export const getPrescription = (id) => {
    return axios.get("api/prescription/"+id)
}
export const searchPatients=(id,fullname,date)=>{
    return axios.get("api/patients/search?id="+id+"&fullname="+fullname+"&date="+date)
}