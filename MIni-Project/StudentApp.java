import java.math.*;
import java.util.*;

class Person{
    String name,email,dob;
    
    public Person(String name, String email, String dob){
        this.name=name;
        this.email=email;
        this.dob=dob;
    }
    void setEmail(String email)
    {
        this.email=email;
    }
}
interface Inter{
    void update();
    void viewProfile();
}
class Student extends Person implements Inter{
    String courses[],degree,id;
    float marks[];
    int attd[],tot[],yr;
    
    Student(String name, String email,String dob, String courses[],String degree,int yr,String id){
        super(name,email,dob);
        this.courses=courses;
        this.id=id;
        this.degree=degree;
        this.yr=yr;
        marks=new float[5];
        attd=new int[5];
        tot=new int[5];
    }
    void setEmail(String email)
    {
        super.setEmail(email);
    }
    void setYear(int yr)
    {
        this.yr=yr;
    }
    void setDegree(String degree)
    {
        this.degree=degree;
    }
    int getYr()
    {
        return yr;
    }
    String getId()
    {
        return id;
    }

    @Override
    public void update(){
        int ch;
        Scanner in = new Scanner(System.in);
        do{
            StudentApp.printline();
            System.out.print("\n\tMENU\n");
            System.out.print("\n\t1 - Change email");
            System.out.print("\n\t2 - Change year");
            System.out.print("\n\t3 - Change degree");
            System.out.print("\n\t4 - Quit\n\tEnter your choice : ");
            ch=in.nextInt();
            if(ch==1)
            {
                String email;
                System.out.print("\n\tEnter new email: ");
                email=in.nextLine();
                email=in.nextLine();
                setEmail(email);
            }
            else if(ch==2)
            {
                int yr;
                System.out.print("\n\tEnter year: ");
                yr=in.nextInt();
                setYear(yr);
            }
            else if(ch==3)
            {
                String degree;
                System.out.print("\n\tEnter new degree: ");
                degree=in.nextLine();
                degree=in.nextLine();
                setDegree(degree);
            }
            else if(ch==4)
                break;
        }while(ch!=4);

    }
    public void showMark()
    {
        StudentApp.printline();
        System.out.println("\n\n\tMARK DETAILS\t");
        System.out.println();
        System.out.println("\n\tName: "+name+"\tID: "+id+"\tYear: "+yr);
        System.out.println("\tCOURSE\tMARKS");
        System.out.println();
        for(int i=0;i<5;i++)
            System.out.println("\t"+courses[i]+"\t"+marks[i]);
    }
    public void showattd(){
        StudentApp.printline();
        System.out.println("\n\n\tATTENDANCE DETAILS");
        System.out.println();
        System.out.println("\n\tName: "+name+"\tID: "+id+"\tYear: "+yr);
        System.out.println("\tCOURSE\tATTENDANCE");
        System.out.println();
        for(int i=0;i<5;i++)
        {
            int d;
            if(tot[i]==0)
                d=1;
            else
                d=tot[i];
        System.out.println("\t"+courses[i]+"\t"+(((float)(attd[i])/(float)(d))*100)+" %");
        }
        
    }
    void show()
    {
        System.out.println("\n\t\t"+id+"\t"+name);
    }

    @Override
    public void viewProfile()
    {
        StudentApp.printline();
        System.out.println("\n\t\tProfile");
        System.out.println("\n\tName \t\t: "+ name);
        System.out.println("\n\tId  \t\t: "+id);
        System.out.println("\n\tDOB  \t\t: "+dob);
        System.out.println("\n\tEmail id\t: "+email);
        System.out.println("\n\tYear\t\t: "+yr);
        System.out.println("\n\tDegree\t\t: "+degree);
    }
    
}
class Teacher extends Person implements Inter{
    String qua, desig,courses[],id;
    float bp,sal;
    
    Teacher(String name, String email,String dob, String courses[],String qua,String desig,float bp,String id){
         super(name,email,dob);
         this.courses=courses;
         this.desig=desig;
         this.bp=bp;
         this.qua=qua;
         this.id=id;
    }
    void setQualf(String q)
    {
        qua=q;
    }
    void setDesig(String d)
    {
        desig=d;
    }
    void calcSalary()
    {
        double hra,ded,da,net;
        da=0.08*bp;
        hra=0.8*bp;
        ded=0.05*bp;
        net=(bp+da+hra)-ded;
        System.out.println("******************************************************************");
        System.out.println("\t\tSALARY DETAILS");
        System.out.println("\tBasic Pay: "+bp);
        System.out.println("\tDaily Allowance: "+da);
        System.out.println("\tHouse Rent Allowance: "+hra);
        System.out.println("\tGross Salary: "+(net+ded));
        System.out.println("\tDeductions(PF): "+ded);
        System.out.println("\tNet Salary: "+net);
    }


    @Override
    public void update(){
        Scanner in = new Scanner(System.in);
        int ch;
        do{
            StudentApp.printline();
            System.out.println("\n\n\t\tMENU");
            System.out.println("\n\t1 - Change email");
            System.out.println("\t2 - Change qualification");
            System.out.println("\t3 - Change designation");
            System.out.print("\t4 - Quit\n\tEnter your choice : ");
            ch=in.nextInt();
            if(ch==1)
            {
                String email;
                System.out.print("\n\tEnter new email: ");
                email=in.nextLine();
                email=in.nextLine();
                setEmail(email);
            }
            else if(ch==2)
            {
                String qualf;
                System.out.print("\n\tEnter qualification: ");
                qualf=in.nextLine();
                qualf=in.nextLine();
                setQualf(qualf);
            }
            else if(ch==3)
            {
                String desig;
                System.out.print("\n\tEnter designation: ");
                desig=in.nextLine();
                desig=in.nextLine();
                setDesig(desig);
            }
            else if(ch==4)
            break;
        }while(ch!=4);

    }
    
    void enterAttd(ArrayList<Student> slist)
    {
        int yr;
        StudentApp.printline();
        Scanner in = new Scanner(System.in);
        System.out.println("\n\t\tEnter Attendance details \n\t\t~~~~~~~~~~~~~~~~~~~~~~");
        String temp;
        System.out.print("\n\tEnter Course: ");
        temp=in.nextLine();
        try{
            int j=0;
            while(courses[j].equals(temp)==false)
                {
                    j+=1;
                    if(j==courses.length)
                        throw new NullPointerException();
                    
                }

            System.out.print("\n\tEnter year: ");
            yr=in.nextInt();
            ArrayList<Student> stu=new ArrayList<Student>();
            stu=StudentApp.findStudents(slist,temp,yr);
            int len=stu.size();
            if(len==0)
                {
                    System.out.println("\n\tNo Students found for given course and year");
                    return;
                }
            for(j=0;j<len;++j)
            {
                System.out.println("\n\t\tId\t\tName");
                stu.get(j).show();
            }
            System.out.print("\n\tEnter Absentees ID (0-stop): ");
            id=in.nextLine();
            id=in.nextLine();
            ArrayList<String> abs_id=new ArrayList<String>();
            while(id.equals("0")==false)
            {
                abs_id.add(id);
                id=in.nextLine();
            }
            for(j=0;j<len;++j)
            {
                for(int k=0;k<5;++k)
                {
                    if(stu.get(j).courses[k].equals(temp))
                        for(int l=0;l<abs_id.size();++l)
                            if(stu.get(j).id.equals(abs_id.get(l))==false)
                            {
                                int x=stu.get(j).attd[k];
                                stu.get(j).attd[k]=x+1;
                                x=stu.get(j).tot[k];
                                stu.get(j).tot[k]=x+1;
                                break;
                            }
                            else
                            {
                                int x=stu.get(j).tot[k];
                                stu.get(j).tot[k]=x+1;
                                break;
                            }
                }
            }
        System.out.println("\n\tAttendance Updated Succussfully!!!\n");
        }catch(NullPointerException e)
        {
            System.out.println("\tAdd Attendance : Permission Denied!!!\n");
        }
    }
    void enterMark(ArrayList<Student> slist)
    {
        int yr;
        StudentApp.printline();
        Scanner in = new Scanner(System.in);
        System.out.println("\n\t\tEnter Mark details \n\t\t~~~~~~~~~~~~~~~~~~~");
        String temp;
        System.out.print("\n\tEnter Course: ");
        temp=in.nextLine();
        try{
            int j=0;
            while(courses[j].equals(temp)==false)
                {
                    j+=1;
                    if(j==courses.length)
                        throw new NullPointerException();
                    
                }

            System.out.print("\n\tEnter year: ");
            yr=in.nextInt();
            ArrayList<Student> stu=new ArrayList<Student>();
            stu=StudentApp.findStudents(slist,temp,yr);
            int len=stu.size();
            if(len==0)
            {
                System.out.println("\n\tNo Students found for given course and year");
                return;
            }
            System.out.println("\n\tCOURSE: "+temp);
            System.out.println("\n\tEnter Marks for: ");
            for(j=0;j<len;++j)
            {
                stu.get(j).show();
                for(int k=0;k<5;++k)
                {
                    if(stu.get(j).courses[k].equals(temp))
                    {
                        //System.out.print("\n\t"+stu.get(j).id+"\t"+stu.get(j).name+" : ");
                        stu.get(j).marks[k]=in.nextFloat();
                        break;
                    }
                }
            }
         System.out.println("\n\tMarks updated Successfully!!!\n");
        }catch(NullPointerException e)
        {
            System.out.println("\tAdd Marks : Permission Denied!!!\n");
        }
    }
    @Override
    public void viewProfile()
    {
        System.out.println("\n\t\tProfile");
        System.out.println("\n\tName \t\t: "+ name);
        System.out.println("\n\tId  \t\t: "+id);
        System.out.println("\n\tDOB  \t\t: "+dob);
        System.out.println("\n\tEmail id\t: "+email);
        System.out.println("\n\tQualification\t: "+qua);
        System.out.println("\n\tDesignation\t: "+desig);
    }
}


public class StudentApp{
    static ArrayList<Student> findStudents(ArrayList<Student> slist,String course,int yr)
    {
        ArrayList<Student> stu=new ArrayList<Student>();
        int n=slist.size();
        for(int i=0;i<n;++i)
        {
            if(slist.get(i).yr == yr)
                for(int j=0;j<5;++j)
                    if(slist.get(i).courses[j].equals(course))
                        {stu.add(slist.get(i));
                            break;}
        }
        return stu;
    }
    static void show(ArrayList<Student> slist)
    {
        for(int j=0;j<slist.size();++j){
            slist.get(j).showattd();
        }
    }
    static void show(ArrayList<Student> slist,int temp_yr)
    {
        for(int j=0;j<slist.size();++j){
            if(slist.get(j).yr==temp_yr)
                slist.get(j).showattd();
        }
    }
    static void show(ArrayList<Student> slist,String temp_id)
    {
        for(int j=0;j<slist.size();++j){
            if(slist.get(j).id.equals(temp_id))
                slist.get(j).showattd();
        }
    }
    static void printline()
    {
        System.out.println("********************************************************************");
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int op;
        String name,email,dob,id,degree,desig,qua;
        Inter iref;
        int attd[],yr;
        float marks[],bp;
        ArrayList<Student> slist=new ArrayList<Student>();
        ArrayList<Teacher> tlist=new ArrayList<Teacher>();
        do
        { 
        int i=0,n;
        printline();
        System.out.println("\t\tMenu\n\t\t~~~~");
        System.out.println("\t1 - Register");
        System.out.println("\t2 - Student");
        System.out.println("\t3 - Teacher");
        System.out.println("\t4 - Exit");
        System.out.print("\n\tEnter your choice: ");
        op=in.nextInt();
        switch(op)
        {
            case 1:
                int ch;
                printline();
                System.out.println("\t\tResister\n\t\t~~~~~~~~~");
                System.out.println("\t1 - Student\n\t2 - Teacher\n\t3 - Quit");
                System.out.print("\n\tEnter your choice: ");
                ch=in.nextInt();
                if(ch!=3)
                {
                    String courses[]=new String[5];
                    System.out.print("\n\tEnter Name: ");
                    name=in.nextLine();
                    name=in.nextLine();
                    System.out.print("\n\tEnter DOB: ");
                    dob=in.next();
                    System.out.print("\n\tEnter ID. NO.: ");
                    id=in.next();
                    System.out.print("\n\tEnter Email ID:  ");
                    email=in.next();
                    if(ch==1){
                        
                        System.out.print("\n\tEnter year: ");
                        yr=in.nextInt();
                        System.out.print("\n\tEnter Degree: ");
                        degree=in.nextLine();
                        degree=in.nextLine();
                        System.out.println("\n\tEnter 5 courses: ");
                        for(i=0;i<5;++i)
                        {
                            courses[i]=new String();
                            courses[i]=in.nextLine();
                        }
                        slist.add(new Student(name,email,dob,courses,degree,yr,id));
                        Collections.sort(slist,Comparator.comparing(Student::getYr).thenComparing(Student::getId));

                    }
                    if(ch==2)
                    {
                        System.out.print("\n\tEnter qualification: ");
                        qua=in.nextLine();
                        qua=in.nextLine();
                        System.out.print("\n\tEnter Designation: ");
                        desig=in.nextLine();
                        System.out.print("\n\tEnter courses handling(0-stop): ");
                        i=0;
                        String temp=in.nextLine();
                        while(temp.equals("0")==false)
                        {
                            courses[i]=new String();
                            courses[i]=temp;
                            temp=in.nextLine();
                            i+=1;
                        }
                        System.out.print("\n\tEnter basic pay : ");
                        bp=in.nextFloat();
                        tlist.add(new Teacher(name,email,dob,courses,qua,desig,bp,id));
                        
                    }
                    System.out.println("\n\tRegistered Succussfully!!!\n");
                    
                }
                break;
            case 2:
                String sid;
                printline();
                System.out.println("\n\t\tStudent\n\t\t~~~~~~~~~");
                System.out.println("\n\tEnter your ID : ");
                sid=in.next();
                n=slist.size();
                i=0;
                try{ 

                    while(i<n&&(sid.equals(slist.get(i).id)==false)){
                        i+=1;
                        if(i==n)
                            throw new IndexOutOfBoundsException();
                    }

                    if(sid.equals(slist.get(i).id))
                    { 
                        do{ 
                            printline();
                            iref=slist.get(i);
                        System.out.print("\n\t1 - View Attendance\n\t2 - View Marks");
                        System.out.print("\n\t3 - View Profile\n\t4 - Update Profile\n\t5 - Quit");
                        System.out.print("\n\tEnter your choice : ");
                        ch=in.nextInt();
                        if(ch==1)
                            slist.get(i).showattd();
                        else if(ch==2)
                            slist.get(i).showMark();
                        else if(ch==3)
                            iref.viewProfile();
                        else if(ch==4)
                            {
                                iref.update();
                                System.out.println("\n\tDetails updated Succussfully");
                            }
                        else 
                            break;
                        }while(true);
                    }
                }catch(IndexOutOfBoundsException e)
                {
                    System.out.println("\n\tNot a Registerd User!!!\n");
                }
                break;
                
            case 3:
                String tid;
                printline();
                System.out.println("\n\t\tTeacher\n\t\t~~~~~~~~~");
                System.out.println("\n\tEnter your ID : ");
                tid=in.next();
                n=tlist.size();
                i=0;
                try{ 

                    while(i<n&&(tid.equals(tlist.get(i).id)==false)){
                        i+=1;
                        if(i==n)
                            throw new IndexOutOfBoundsException();
                    }

                    if(tid.equals(tlist.get(i).id))
                    { 
                        do{ 
                        printline();
                        iref=tlist.get(i);
                        System.out.print("\n\t1 - View Student Attendance\n\t2 - View Student Marks");
                        System.out.print("\n\t3 - Enter Attendance\n\t4 - Enter Marks");
                        System.out.print("\n\t5 - View Profile\n\t6 - Update Profile\n\t7 - View Payslip\n\t8 - Quit");
                        System.out.print("\n\tEnter your choice : ");
                        ch=in.nextInt();
                        if(ch==1)
                            {
                                int x;
                                do{
                                    printline();
                                    System.out.println("\n\t\t1 - All\n\t\t2 - Select Year\n\t\t3 - Select Student Id\n\t\t4 - Quit");
                                    System.out.print("\n\t\tEnter your choice : ");
                                    x=in.nextInt();
                                    if(x==1)
                                        show(slist);
                                    else if(x==2)
                                    {
                                        int temp_yr;
                                        System.out.print("\n\tEnter year: ");
                                        temp_yr=in.nextInt();
                                        show(slist,temp_yr);
                                    }
                                    else if(x==3)
                                    {
                                        String temp_id;
                                        System.out.print("\n\tEnter ID: ");
                                        temp_id=in.nextLine();
                                        temp_id=in.nextLine();
                                        show(slist,temp_id);
                                    }
                                    else
                                        break;
                                }while(true);
                            }
                        else if(ch==2)
                            {
                                int x;
                                do{
                                    printline();
                                    System.out.println("\n\t\t1 - All\n\t\t2 - Select Year\n\t\t3 - Select Student Id\n\t\t4 - Quit");
                                    System.out.print("\n\t\tEnter your choice : ");
                                    x=in.nextInt();
                                    if(x==1)
                                        for(int j=0;j<slist.size();++j){
                                            slist.get(j).showMark();
                                        }
                                    else if(x==2)
                                    {
                                        int temp_yr;
                                        System.out.print("\n\tEnter year: ");
                                        temp_yr=in.nextInt();
                                        for(int j=0;j<slist.size();++j){
                                            if(slist.get(j).yr==temp_yr)
                                                slist.get(j).showMark();
                                        }
                                    }
                                    else if(x==3)
                                    {
                                        String temp_id;
                                        System.out.print("\n\tEnter ID: ");
                                        temp_id=in.nextLine();
                                        temp_id=in.nextLine();
                                        for(int j=0;j<slist.size();++j){
                                            if(slist.get(j).id.equals(temp_id))
                                                slist.get(j).showMark();
                                        }
                                    }
                                    else
                                        break;
                                }while(true);
                            }
                        else if(ch==3)
                            tlist.get(i).enterAttd(slist);
                        else if(ch==4)
                            tlist.get(i).enterMark(slist);
                        else if(ch==5)
                            iref.viewProfile();
                        else if(ch==6)
                            {
                                iref.update();
                                System.out.println("\n\tDetails updated Succussfully");
                            }
                        else if(ch==7)
                        {
                            tlist.get(i).calcSalary();
                        }
                        else 
                            break;
                        }while(true);

                    }
                }catch(IndexOutOfBoundsException e)
                {
                    System.out.println("\n\tNot a Registerd User!!!\n");
                }
                break;
            case 4:
                System.exit(0);
        }
    }while(true);
        
    }
}