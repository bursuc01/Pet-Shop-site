import '../App'
import '../CSS/App.css'
import '../CSS/Shopping.css';
import React, { useEffect, useState } from 'react'
import { getQuestion } from '../services/Question/Question';
import image from '../Images/whiskas.png';

export default function QuestionComp(){
    const [questions, setQuestions] = useState([]);
    
    useEffect(() => {
        getQuestion((data) => {
            if(data !== null){
                setQuestions(data);
            }
        });
    }, []);

    return(
        <div className="App">
            {questions.map((question) => (
                    <div key={question.id} className="">
                        <h1>{question.questionText}</h1>
                        <h1>{question.answerText}</h1>
                    </div>
                ))}
        </div>
    );
}