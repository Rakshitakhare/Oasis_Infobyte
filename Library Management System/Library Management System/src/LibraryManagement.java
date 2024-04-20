import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LibraryManagement extends JFrame implements ActionListener {
    private String Username;
    //components for login page
    private JPanel loginpanel;
    private JTextField userJTextField;
    private JPasswordField uPasswordField;
    private JButton userloginButton;
    private JButton adminloginButton;
    private JButton signupButton;

    //component for signup page
    private JPanel signupPanel;
    private JTextField userField;
    private JPasswordField userpassword;
    private JTextField username;
    private JTextField contact;
    private JButton confirmsignupButton;

    //components for home page of user
    private JPanel homeuPanel;
    private JButton issueButton;
    private JButton returnButton;
    private JButton extendButton;
    private JButton showbook;

    //components for homepage of admin
    private JPanel homeaPanel;
    private JButton showbooks;
    private JButton addbook;
    private JButton addnewadmin;
    private JButton removeadmin;
    private JButton removeuser;
    private JButton checkforfine;



    //components for showing books in user
    private JTable bookTable;
    private DefaultTableModel model;
    //component for issuing book
    private JPanel issuebook;
    private JTextField bookid;
    private JTextField duration;
    private JButton confirmissue;
    private JButton homeuissue;
    private JTextField dateofissue;

    //components for returning book
    private JPanel returnbook;
    private JTextField bookidret;
    private JTextField dateissuedon;
    private JTextField dateofreturn;
    private JButton confirmreturn;
    private JButton homeret;

    //components for extending time
    private JPanel extend;
    private JTextField bookidext;
    private JTextField duration_ext;
    private JButton confirmextend;
    private JButton homeuext;

    //components for adding book
    private JPanel addbookpanel;
    private JTextField bookidadd;
    private JTextField booknameadd;
    private JTextField bookpriceadd;
    private JTextField bookquantityadd;
    private JTextField bookauthoradd;
    private JButton confirmadd;
    private JButton homeaadd;

    //components for adding new admin
    private JPanel addadminpanel;
    private JTextField adminuidadd;
    private JTextField adminnameadd;
    private JPasswordField adminpassadd;
    private JTextField admincontact;
    private JButton confirmaddadmin;
    private JButton homeadminadd;

    //components for removing an admin
    private JPanel removeadminpanel;
    private JTextField adminuidremove;
    private JPasswordField adminpassremove;
    private JButton confirmremoveadmin;
    private JButton homearemadmin;

    //components for removing a user
    private JPanel removeuserpanel;
    private JTextField useridremove;
    private JPasswordField adminpassremoveu;
    private JButton confirmuserremove;
    private JButton homearemoveuser;
    //connection
    private Connection conn;
    public LibraryManagement() {
        // Initialize database connection
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarymanagement", "root",
              "shubham01");
          conn.createStatement();
        }
        catch (SQLException e) {
          e.printStackTrace();
        }
        // Initialize login page components
        userJTextField = new JTextField(20);
        uPasswordField = new JPasswordField(20);
        userloginButton = new JButton("Login");
        userloginButton.addActionListener(this);
        adminloginButton = new JButton("Admin Login");
        adminloginButton.addActionListener(this);
        signupButton = new JButton("Signup");
        signupButton.addActionListener(this);

        // Initialize signup page component
        userField = new JTextField(20);
        userpassword = new JPasswordField(20);
        username = new JTextField(20);
        contact = new JTextField(20);
        confirmsignupButton = new JButton("Signup");
        confirmsignupButton.addActionListener(this); 

        // Initialize homepage components of user
        showbook = new JButton("Show Books");
        showbook.addActionListener(this);
        issueButton = new JButton("Issue a Book");
        issueButton.addActionListener(this);
        returnButton = new JButton("Return a Book");
        returnButton.addActionListener(this);
        extendButton = new JButton("Extend the Time");
        extendButton.addActionListener(this);
        
        

        // Initialize homepage components of admin
        showbooks = new JButton("Show Available Books");
        showbooks.addActionListener(this);
        addbook = new JButton("Add a new Book");
        addbook.addActionListener(this);
        addnewadmin = new JButton("Add a new Admin");
        addnewadmin.addActionListener(this);
        removeadmin = new JButton("Remove Admin");
        removeadmin.addActionListener(this);
        removeuser = new JButton("Remove User");
        removeuser.addActionListener(this);
        checkforfine = new JButton("Check for Fine");
        checkforfine.addActionListener(this);
        
        // Initialize issue components
        bookid = new JTextField(20);
        duration = new JTextField(10);
        dateofissue = new JTextField(10);
        confirmissue = new JButton("Issue");
        confirmissue.addActionListener(this);
        homeuissue = new JButton("Back");
        homeuissue.addActionListener(this);

        // Initialize return components
        bookidret = new JTextField(20);
        dateofreturn = new JTextField(10);
        dateissuedon = new JTextField(20);
        confirmreturn = new JButton("Return");
        confirmreturn.addActionListener(this);
        homeret = new JButton("Back");
        homeret.addActionListener(this);

        // Initialize extend components
        bookidext = new JTextField(20);
        duration_ext = new JTextField(10);
        confirmextend = new JButton("Extend Time");
        confirmextend.addActionListener(this);
        homeuext = new JButton("Back");
        homeuext.addActionListener(this);
        
        // Initialize add book components
        bookidadd = new JTextField(20);
        booknameadd = new JTextField(20);
        bookauthoradd = new JTextField(20);
        bookpriceadd = new JTextField(10);
        bookquantityadd = new JTextField(10);
        confirmadd = new JButton("Add Book");
        confirmadd.addActionListener(this);
        homeaadd = new JButton("Back");
        homeaadd.addActionListener(this);

        //Initialize add admin components
        adminuidadd = new JTextField(20);
        adminnameadd = new JTextField(20);
        adminpassadd = new JPasswordField(10);
        admincontact = new JTextField(20);
        confirmaddadmin = new JButton("Add Admin");
        confirmaddadmin.addActionListener(this);
        homeadminadd = new JButton("Back");
        homeadminadd.addActionListener(this);

        //Initialize remove admin components
        adminuidremove = new JTextField(20);
        adminpassremove = new JPasswordField(20);
        confirmremoveadmin = new JButton("Remove Admin");
        confirmremoveadmin.addActionListener(this);
        homearemadmin = new JButton("Back");
        homearemadmin.addActionListener(this);
        
        //Initialize remove user components
        useridremove = new JTextField(20);
        adminpassremoveu = new JPasswordField(20);
        confirmuserremove = new JButton("Remove User");
        confirmuserremove.addActionListener(this);
        homearemoveuser = new JButton("Back");
        homearemoveuser.addActionListener(this);
    }
    private void login()
    {
        loginpanel = new JPanel(new GridLayout(4,2));
        loginpanel.add(new JLabel("User ID"));
        loginpanel.add(userJTextField);
        loginpanel.add(new JLabel("Password"));
        loginpanel.add(uPasswordField);
        loginpanel.add(userloginButton);
        loginpanel.add(adminloginButton);
        loginpanel.add(signupButton);
        add(loginpanel);

        setTitle("Library Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == userloginButton)
        {
            String user = userJTextField.getText();
            String pass = String.valueOf(uPasswordField.getPassword());
            if(validateulogin(user,pass)){
                showuhomepage(Username);
            }
            else{
                JOptionPane.showMessageDialog(this,"User Not Found !! Please Signup");
            }
        }
        else if(e.getSource() == adminloginButton)
        {
            String user = userJTextField.getText();
            String pass = String.valueOf(uPasswordField.getPassword());
            if(validatealogin(user,pass))
            {
                showahomepage(Username);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Admin Not Found !! Please Contact the Administrator");
            }
        }
        else if(e.getSource() == signupButton)
        {
            signup();
        }
        else if(e.getSource() == confirmsignupButton){
            String userid = userField.getText();
            String uname = username.getText();
            String pass = String.valueOf(userpassword.getPassword());
            String cont = contact.getText();
            if(confirmsignup(uname,userid,pass,cont))
            {
                JOptionPane.showMessageDialog(this, "Signup Successful");
                remove(signupPanel);
                login();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Signup Unsuccessful !! Please Retry");
            }
        }
        else if(e.getSource() == showbook)
        {
           showbook();
           remove(bookTable);
        }
        else if(e.getSource() == issueButton)
        {
            issuebook(Username);
        }
        else if(e.getSource() == homeuissue)
        {
            remove(issuebook);
            showuhomepage(Username);
        }
        else if(e.getSource() == confirmissue)
        {
            if(confirmissue(userJTextField.getText()))
            {
                JOptionPane.showMessageDialog(this, "Book Issued Successfully");
                remove(issuebook);
                showuhomepage(Username);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Cannot Issue the book at this moment !!");
            }
        }
        else if(e.getSource() == returnButton)
        {
            returnbook();
        }
        else if(e.getSource() == confirmreturn)
        {
            if(confirmretrun())
            {
                JOptionPane.showMessageDialog(this, "Book returned Successfully");
                remove(returnbook);
                showuhomepage(Username);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Failed to return the book at this moment!!");

            }
        }
        else if(e.getSource() == homeret)
        {
            remove(returnbook);
            showuhomepage(Username);
        }
        else if(e.getSource() == extendButton)
        {
            extendbook();
        }
        else if(e.getSource() == confirmextend)
        {
            if(confirmextend())
            {
                JOptionPane.showMessageDialog(this, "Time Extended Successfully");
                remove(extend);
                showuhomepage(Username);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Failed to extend the time at this moment !!");
            }
        }
        else if(e.getSource() == homeuext)
        {
            remove(extend);
            showuhomepage(Username);
        }
        else if(e.getSource() == showbooks)
        {
            showabook();
        }
        else if(e.getSource() == addbook)
        {
            addbook();
        }
        else if(e.getSource() == confirmadd)
        {
            if(confirmaddbook())
            {
                JOptionPane.showMessageDialog(this, "Book added Successfully");
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Failed to add the book !!");
            }
        }
        else if(e.getSource() == homeaadd)
        {
            remove(addbookpanel);
            showahomepage(Username);
        }
        else if(e.getSource() == addnewadmin)
        {
            addnewadmin();
        }
        else if(e.getSource() == confirmaddadmin)
        {
            if(confirmaddadmin())
            {
                JOptionPane.showMessageDialog(this,"Admin added Successfully");
            }
            else{
                JOptionPane.showMessageDialog(this, "Failed to add New Admin at this Moment!!");
            }
        }
        else if(e.getSource() == homeadminadd)
        {
            remove(addadminpanel);
            showahomepage(Username);
        }
        else if(e.getSource() == removeadmin)
        {
            removeadmin();
        }
        else if(e.getSource() == confirmremoveadmin)
        {
            if(confirmremoveadmin())
            {
                JOptionPane.showMessageDialog(this, "Admin removed Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Failed to remove the Admin at this moment !!");
            }
        }
        else if(e.getSource()==homearemadmin)
        {
            remove(removeadminpanel);
            showahomepage(Username);
        }
        else if(e.getSource() == removeuser)
        {
            removeuser();
        }   
        else if(e.getSource() == confirmuserremove)
        {
            if(confirmremoveuser())
            {
                JOptionPane.showMessageDialog(this, "User removed Successfully");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Failed to remove the User !!");
            }
        }
        else if(e.getSource() == homearemoveuser)
        {
            remove(removeuserpanel);
            showahomepage(Username);
        }
        else if(e.getSource() == checkforfine)
        {
            showfine();
        }
    }


    private boolean confirmsignup(String uname,String uid,String pass,String cont)
    {
        try {
            String sql = "insert into user(user_id,password,contact_info,user_name)values(?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, uid);
            statement.setString(2, pass);
            statement.setString(3, cont);
            statement.setString(4, uname);
            statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void showbook()
    {   
        remove(homeuPanel);
        model = new DefaultTableModel();
        bookTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane,BorderLayout.CENTER);
        try {
            PreparedStatement statement = conn.prepareStatement("select book_id,book_name,author,price from book;");
            ResultSet res = statement.executeQuery();
            int columncount = res.getMetaData().getColumnCount();
            for(int i=1; i<=columncount;i++)    
            {
                model.addColumn(res.getMetaData().getColumnName(i));
            }
            while (res.next()) {
                Object[] row = new Object[columncount];
                for(int i=1;i<=columncount;i++)
                {
                    row[i-1] = res.getObject(i);
                }
                model.addRow(row);
            }
            res.close();
            statement.close();
            setVisible(true);
            setSize(500,500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void returnbook()
    {
        remove(homeuPanel);
        returnbook = new JPanel(new GridLayout(4,2));
        returnbook.add(new JLabel("Book ID"));
        returnbook.add(bookidret);
        returnbook.add(new JLabel("Issuing Date"));
        returnbook.add(dateissuedon);
        returnbook.add(new JLabel("Returning Date"));
        returnbook.add(dateofreturn);
        returnbook.add(confirmreturn);
        returnbook.add(homeret);
        add(returnbook);
        setVisible(true);
    }
    private boolean confirmretrun()
    {
        String date = "";
        int duration = 0;
        boolean ret = false;
        try
        {
            PreparedStatement statement = conn.prepareStatement("select date_borrowed_on ,duration_month from book_borrowed where book_id = ? and borrowed_by = ? and date_borrowed_on = ?;");
            statement.setInt(1, Integer.parseInt(bookidret.getText()));
            statement.setString(2, userJTextField.getText());
            statement.setString(3, dateissuedon.getText());
            ResultSet res = statement.executeQuery();
            res.next();
            date = res.getString("date_borrowed_on");
            duration = res.getInt("duration_month");
            String[] datissue = date.split("-");
            String[] datret = dateofreturn.getText().split("-");
            int month_gap = Integer.parseInt(datret[1]) - Integer.parseInt(datissue[1]);
            int date_gap = Integer.parseInt(datret[2]) - Integer.parseInt(datissue[2]);
            int gap = month_gap*28 +date_gap;
            int fine = ((month_gap-duration)*28 + date_gap)*50;
            if(gap>(duration*28))
            {
                PreparedStatement statement1 = conn.prepareStatement("update book_borrowed set fine_generated = ? where book_id = ? and borrowed_by = ? and date_borrowed_on = ?;");
                statement1.setInt(1, fine);
                statement1.setInt(2,Integer.parseInt(bookidret.getText()));
                statement1.setString(3,userJTextField.getText());
                statement1.setString(4,dateissuedon.getText());
                statement1.execute();
                int opt = JOptionPane.showConfirmDialog(this,"You had returned the book late !! The fine generated is"+fine);
                if(opt==0)
                {
                    statement1 = conn.prepareStatement("delete from book_borrowed where book_id = ? and borrowed_by = ? and date_borrowed_on = ?;");
                    statement1.setInt(1, Integer.parseInt(bookidret.getText()));
                    statement1.setString(2, userJTextField.getText());
                    statement1.setString(3,dateissuedon.getText());
                    statement1.execute();
                    statement1 = conn.prepareStatement("select quantity from book where book_id = ?");
                    statement1.setInt(1,Integer.parseInt(bookidret.getText()));
                    ResultSet rest = statement1.executeQuery();
                    rest.next();
                    int quantity = rest.getInt("quantity");
                    quantity +=1;
                    statement = conn.prepareStatement("update book set quantity = ? where book_id = ?;");
                    statement.setInt(1, quantity);
                    statement.setInt(2, Integer.parseInt(bookidret.getText()));
                    statement.execute();
                    ret = true;
                }
                else
                {
                    JOptionPane.showMessageDialog(this,"You have cancelled the Return Process");
                    ret = false;
                }    
            }
            else
            {
                statement = conn.prepareStatement("delete from book_borrowed where book_id = ? and borrowed_by = ? and date_borrowed_on = ?;");
                statement.setInt(1, Integer.parseInt(bookidret.getText()));
                statement.setString(2, userJTextField.getText());
                statement.setString(3,dateissuedon.getText());
                statement.execute();
                statement = conn.prepareStatement("select quantity from book where book_id = ?");
                statement.setInt(1,Integer.parseInt(bookidret.getText()));
                ResultSet rest = statement.executeQuery();
                rest.next();
                int quantity = rest.getInt("quantity");
                quantity +=1;
                statement = conn.prepareStatement("update book set quantity = ? where book_id = ?;");
                statement.setInt(1, quantity);
                statement.setInt(2, Integer.parseInt(bookidret.getText()));
                statement.execute();
                ret = true;
            }
            return ret;   
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    private void issuebook(String user)
    {
        remove(homeuPanel);
        issuebook = new JPanel(new GridLayout(4,2));
        issuebook.add(new JLabel("Book ID"));
        issuebook.add(bookid);
        issuebook.add(new JLabel("Duration in Months"));
        issuebook.add(duration);
        issuebook.add(new JLabel("Date of Issuing"));
        issuebook.add(dateofissue);
        issuebook.add(confirmissue);
        issuebook.add(homeuissue);
        add(issuebook);
        setVisible(true);
    }
    private boolean confirmissue(String user)
    {
        int quantity = 0;
        try
        {
        PreparedStatement statement = conn.prepareStatement("select quantity from book where book_id = ?;");
        statement.setInt(1,Integer.parseInt(bookid.getText()));
        ResultSet res = statement.executeQuery();
        res.next();
        quantity = Integer.parseInt(res.getString("quantity"));
        if(quantity>0)
        {
            try{
                PreparedStatement statement1 = conn.prepareStatement("insert into book_borrowed(book_id,borrowed_by,duration_month,date_borrowed_on)values(?,?,?,?);");
                statement1.setInt(1,Integer.parseInt(bookid.getText()));
                statement1.setString(2, user);
                statement1.setInt(3, Integer.parseInt(duration.getText()));
                statement1.setString(4, dateofissue.getText());
                statement1.execute();
                quantity = quantity-1;
                statement1 = conn.prepareStatement("update book set quantity = ? where book_id = ?");
                statement1.setInt(1, quantity);
                statement1.setInt(2, Integer.parseInt(bookid.getText()));
                statement1.execute();
                }
                catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        else{
            JOptionPane.showMessageDialog(this,"Book is currently Not Available !!");
            return false;
        }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    private void signup()
    {
        remove(loginpanel);
        signupPanel = new JPanel(new GridLayout(5,2));
        signupPanel.add(new JLabel("User ID"));
        signupPanel.add(userField);
        signupPanel.add(new JLabel("User Name"));
        signupPanel.add(username);
        signupPanel.add(new JLabel("Password"));
        signupPanel.add(userpassword);
        signupPanel.add(new JLabel("Contact Details"));
        signupPanel.add(contact);
        signupPanel.add(confirmsignupButton);
        add(signupPanel);
        setVisible(true);
    }
    private boolean validatealogin(String user,String pass)
    {
        String password = "";
        try {
            String sql = "select admin_password,admin_name from admin where admin_userid = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,user);
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Username = res.getString("admin_name");
                password = res.getString("admin_password");
            }
            if(password.compareTo(pass)==0)
            {
                return true;
            }
            else{
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    private void extendbook()
    {
        remove(homeuPanel);
        extend = new JPanel(new GridLayout(3,2));
        extend.add(new JLabel("Book ID"));
        extend.add(bookidext);
        extend.add(new JLabel("Duration to extend"));
        extend.add(duration_ext);
        extend.add(confirmextend);
        extend.add(homeuext);
        add(extend);
        setVisible(true);
    }
    private boolean confirmextend()
    {
        try {
            PreparedStatement statement = conn.prepareStatement("select duration_month from book_borrowed where book_id = ? and borrowed_by = ?");
            statement.setInt(1,Integer.parseInt(bookidext.getText()));
            statement.setString(2,userJTextField.getText());
            ResultSet res = statement.executeQuery();
            res.next();
            int duration = res.getInt("duration_month");
            duration+= Integer.parseInt(duration_ext.getText());
            statement = conn.prepareStatement("update book_borrowed set duration_month = ? where book_id = ?");
            statement.setInt(1,duration);
            statement.setInt(2, Integer.parseInt(bookidext.getText()));
            return !statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean validateulogin(String user,String pass)
    {
        String password = "";
        String sql = "select user_name,password from user where user_id = ?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,user);
            ResultSet res = statement.executeQuery();
            while(res.next())
            {
                password = res.getString("password");
                Username = res.getString("user_name");
            }
            if(pass.compareTo(password)==0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    private void showuhomepage(String user)
    {
        remove(loginpanel);
        homeuPanel = new JPanel(new GridLayout(5,1));
        homeuPanel.add(new JLabel("Welcome "+user));
        homeuPanel.add(showbook);
        homeuPanel.add(issueButton);
        homeuPanel.add(returnButton);
        homeuPanel.add(extendButton);
        add(homeuPanel);
        setVisible(true);
    }
    private void showahomepage(String user)
    {
        remove(loginpanel);
        homeaPanel = new JPanel(new GridLayout(7,1));
        homeaPanel.add(new JLabel("Welcome Admin "+user));
        homeaPanel.add(showbooks);
        homeaPanel.add(addbook);
        homeaPanel.add(addnewadmin);
        homeaPanel.add(removeadmin);
        homeaPanel.add(removeuser);
        homeaPanel.add(checkforfine);
        add(homeaPanel);
        setVisible(true);
    }
    private void showabook()
    {
        remove(homeaPanel);
        model = new DefaultTableModel();
        bookTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane,BorderLayout.CENTER);
        try {
            PreparedStatement statement = conn.prepareStatement("select book_id,book_name,author,price,quantity from book;");
            ResultSet res = statement.executeQuery();
            int columncount = res.getMetaData().getColumnCount();
            for(int i=1; i<=columncount;i++)    
            {
                model.addColumn(res.getMetaData().getColumnName(i));
            }
            while (res.next()) {
                Object[] row = new Object[columncount];
                for(int i=1;i<=columncount;i++)
                {
                    row[i-1] = res.getObject(i);
                }
                model.addRow(row);
            }
            res.close();
            statement.close();
            setVisible(true);
            setSize(500,500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void addbook()
    {
        remove(homeaPanel);
        addbookpanel = new JPanel(new GridLayout(6,2));
        addbookpanel.add(new JLabel("Book ID"));
        addbookpanel.add(bookidadd);
        addbookpanel.add(new JLabel("Book Name"));
        addbookpanel.add(booknameadd);
        addbookpanel.add(new JLabel("Book Author"));
        addbookpanel.add(bookauthoradd);
        addbookpanel.add(new JLabel("Price"));
        addbookpanel.add(bookpriceadd);
        addbookpanel.add(new JLabel("Quantity"));
        addbookpanel.add(bookquantityadd);
        addbookpanel.add(confirmadd);
        addbookpanel.add(homeaadd);
        add(addbookpanel);
        setVisible(true);
    }
    private boolean confirmaddbook()
    {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into book(book_id,book_name,author,price,quantity)values(?,?,?,?,?)");
            statement.setInt(1, Integer.parseInt(bookidadd.getText()));
            statement.setString(2, booknameadd.getText());
            statement.setString(3, bookauthoradd.getText());
            statement.setInt(4,Integer.parseInt(bookpriceadd.getText()));
            statement.setInt(5, Integer.parseInt(bookquantityadd.getText()));
            return !statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void addnewadmin()
    {
        remove(homeaPanel);
        addadminpanel = new JPanel(new GridLayout(5,2));
        addadminpanel.add(new JLabel("Admin ID"));
        addadminpanel.add(adminuidadd);
        addadminpanel.add(new JLabel("Admin Name"));
        addadminpanel.add(adminnameadd);
        addadminpanel.add(new JLabel("Password"));
        addadminpanel.add(adminpassadd);
        addadminpanel.add(new JLabel("Contact"));
        addadminpanel.add(admincontact);
        addadminpanel.add(confirmaddadmin);
        addadminpanel.add(homeadminadd);
        add(addadminpanel);
        setVisible(true);

    }
    private boolean confirmaddadmin()
    {
        try {
            PreparedStatement statement = conn.prepareStatement("insert into admin values(?,?,?,?)");
            statement.setString(1,adminuidadd.getText());
            statement.setString(2,String.valueOf(adminpassadd.getPassword()));
            statement.setString(3,adminnameadd.getText());
            statement.setString(4,admincontact.getText());
            return !statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void removeadmin()
    {
        remove(homeaPanel);
        removeadminpanel = new JPanel(new GridLayout(3,2));
        removeadminpanel.add(new JLabel("Admin User ID"));
        removeadminpanel.add(adminuidremove);
        removeadminpanel.add(new JLabel("Your Admin Password"));
        removeadminpanel.add(adminpassremove);
        removeadminpanel.add(confirmremoveadmin);
        removeadminpanel.add(homearemadmin);
        add(removeadminpanel);
        setVisible(true);
    }
    private boolean confirmremoveadmin()
    {
        try {
            PreparedStatement statement = conn.prepareStatement("select admin_password from admin where admin_userid = ?");
            statement.setString(1, userJTextField.getText());
            ResultSet res = statement.executeQuery();
            res.next();
            String password = res.getString("admin_password");
            if(password.compareTo(String.valueOf(adminpassremove.getPassword()))==0 && adminuidremove.getText().compareTo(userJTextField.getText())!=0)
            {
                statement = conn.prepareStatement("delete from admin where admin_userid = ?");
                statement.setString(1, adminuidremove.getText());
                return !statement.execute();
            }
            else if(adminuidremove.getText().compareTo(userJTextField.getText())==0)
            {
                JOptionPane.showMessageDialog(this,"You can't remove your self as admin !!");
                return false;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Wrong Admin Password !! Please try again");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void removeuser()
    {
        remove(homeaPanel);
        removeuserpanel = new JPanel(new GridLayout(3,2));
        removeuserpanel.add(new JLabel("User ID"));
        removeuserpanel.add(useridremove);
        removeuserpanel.add(new JLabel("Your Admin Password"));
        removeuserpanel.add(adminpassremoveu);
        removeuserpanel.add(confirmuserremove);
        removeuserpanel.add(homearemoveuser);
        add(removeuserpanel);
        setVisible(true);

    }
    
    private boolean confirmremoveuser()
    {
        try {
            PreparedStatement statement = conn.prepareStatement("select admin_password from admin where admin_userid = ?");
            statement.setString(1, userJTextField.getText());
            ResultSet res = statement.executeQuery();
            res.next();
            String passwor = res.getString("admin_password");
            String pass = String.valueOf(adminpassremoveu.getPassword());
            if(pass.compareTo(passwor)==0)
            {
                statement = conn.prepareStatement("delete from user where user_id = ?");
                statement.setString(1, useridremove.getText());
                return !statement.execute();
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Wrong Admin Passwrod !!");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void showfine()
    {
        remove(homeaPanel);
        model = new DefaultTableModel();
        bookTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane,BorderLayout.CENTER);
        try {
            PreparedStatement statement = conn.prepareStatement("select book_id,borrowed_by,fine_generated from book_borrowed");
            ResultSet res = statement.executeQuery();
            int columncount = res.getMetaData().getColumnCount();
            for(int i=1; i<=columncount;i++)    
            {
                model.addColumn(res.getMetaData().getColumnName(i));
            }
            while (res.next()) {
                Object[] row = new Object[columncount];
                for(int i=1;i<=columncount;i++)
                {
                    row[i-1] = res.getObject(i);
                }
                model.addRow(row);
            }
            res.close();
            statement.close();
            setVisible(true);
            setSize(500,500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        new LibraryManagement().login();
    }
}
