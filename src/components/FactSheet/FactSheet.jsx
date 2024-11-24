import { useEffect,useState } from "react";
imp

function FactSheet(patient) {
    const [isExaminationResult,setExaminationResult]=useState({})
    useEffect(()=>{
        
    },[])
    return (
        <>
            <div>
                <h1>Phiếu kết quả khám</h1>
                <dir>
                    <p>ID: {patient.id}</p>
                    <p>Họ và tên: {patient.fullname}</p>
                    <p>Giới tính: {patient.sex}</p>
                    <p>Năm sinh: {patient.yearOfBirth}</p>
                    <p>Địa chỉ: {patient.address}</p>
                </dir>
                <div>
                    <p>Ngày khám: </p>
                    <p>Triệu chứng: </p>
                    <p>Chuẩn đoán: </p>
                </div>
            </div>
        </>
    );
}

export default FactSheet;
