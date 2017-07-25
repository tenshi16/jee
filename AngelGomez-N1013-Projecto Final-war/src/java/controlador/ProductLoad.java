/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clases
 */
public class ProductLoad extends HttpServlet {
      private static final long serialVersionUID = 1L;
      
      public ProductLoad(){
      super();
      }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductLoad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductLoad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           ArrayList<Producto> list = new ArrayList<Producto>();
           list.add(new Producto("1","Intel Core i7",334,"With faster,"
                           + " intelligent, multi-core technology that applies processing power where it's needed most, "
                           + "Intel Core i7 processors deliver an incredible breakthrough in PC performance. You'll "
                           + "multitask applications faster and unleash incredible digital media creation. And you'll "
                           + "experience maximum performance for everything you do.",30,"img/1.jpg"));
           
           list.add(new Producto("2","GeForce GTX 1070",438,"The EVGA GeForce "
                           + "GTX 1070 featuring EVGA ACX 3.0 cooling has arrived. This new graphics card features "
                           + "NVIDIA's new \"Pascal\" graphics processor which is the most advanced gaming GPU ever "
                           + "created. This breakthrough GPU delivers industry-leading performance, innovative "
                           + "new gaming technologies, and immersive next-gen VR. These cards also feature EVGA "
                           + "ACX 3.0 cooling technology. EVGA ACX 3.0 once again brings new and exciting features "
                           + "to the award winning EVGA ACV cooling technology. SHP 2.0 gives increased heat pipes "
                           + "and copper contact area for cooler operation, and optimized fan curve for even quieter "
                           + "gaming. Of course, ACX 3.0 coolers also feature optimized swept fan blades, double ball "
                           + "bearing and an extreme low power motor, delivering more air flow with less power, unlocking "
                           + "additional power for the GPU.",30,"img/2.jpg"));
           
           list.add(new Producto("3","Kingston HyperX FURY 8GB",43,"Get in the game with HyperX FURY. Even newbies get "
                           + "up to speed fast, since FURY automatically recognizes its host platform and "
                           + "automatically overclocks to the highest frequency published - up to 1866MHz¹ - "
                           + "providing plenty of power for your next deathmatch.",30,"img/3.jpg"));
           
           list.add(new Producto("4","Honor 8 Unlocked Phone 32GB",399,"You have"
                   + " the power to push culture forward. That’s why Honor created "
                   + "a phone for you - the new Honor 8. It’s the smartphone that"
                   + " opens your eyes to a world of possibilities. The innovative"
                   + " bionic 12MP dual lenses of the Honor 8 are your eyes to the "
                   + "world. One lens allows for rich color and the other lens is "
                   + "monochrome to give you more light and increased sharpness. "
                   + "Together they help you capture crisper, more detailed photos "
                   + "day and night. Plus, the fusion focus technology of laser, "
                   + "depth, and contrast helps you take the best pictures-even under "
                   + "the most challenging conditions. The premium, slick body of the"
                   + " Honor 8 is made with heavy dual glass-front and back. "
                   + "Its aluminum alloy, 15-layer craftsmanship, and light-catching"
                   + " glass finish makes you stand out from the crowd. Supported by"
                   + " Smart Power 4.0, the Honor 8 has maximum long-lasting battery "
                   + "life that lasts all day and fast-charging technology to reach 47% "
                   + "power in just 30 minutes. So when you’re out there changing the world, "
                   + "Honor 8 has you covered-with up to 10 hours of nonstop video playback "
                   + "and a speedy recharge. The Honor 8: Beautiful design, top-flight specs,"
                   + " game-changing camera technology, and maximum power. Honor 8 - Eyes to "
                   + "the World.",30,"img/4.jpg"));
            list.add(new Producto ("5","Logitech Z506 Surround Sound Home Theater ", 69,"Logitech surround sound speakers z506—for when you want to be "
                    + "moved by big, 5.1 surround sound from your music, movies"
                    + " and games.Connectors: 3x 0.14\" / 3.5 mm Audio-In Jacks,"
                    + " 1x 0.14\" / 3.5 mm Headphone Jack, 2x Stereo RCA Input Jacks,"
                    + " 4x RCA Input Jacks for Speaker System and 1x DB-9 Pin Connector.",30,"img/5.jpg"));
            list.add(new Producto ("6","Dell 15.6-Inch Gaming Laptop",699,"Multi-tasking processing:"
                    + " With 6th Gen Intel i5 Quad-Core processors, you’ll have all the power you need to "
                    + "enjoy both gaming and entertainment.\n" +
"\n" +
"Stream and re-stream videos: The NVIDIA GeForce"
                    + " GTX 960M is your performance-class"
                    + " graphics card with 4GB GDDR5 discrete memory. "
                    + "This graphics powerhouse gives you high frame-per-second "
                    + "rates in games and accelerates video editing and transcoding.",30,"img/6.jpg"));
            
            
            list.add(new Producto ("7","Apple 13 Inch MacBook Pro ",923,"The 13-inch"
                    + " MacBook Pro is designed with the following features to reduce"
                    + " environmental impact, Arsenic-free display glass, Mercury-free"
                    + " LED-backlit display, Brominated flame retardant free, PVC-free, "
                    + "Energy Efficient Ethernet enabled, Highly recyclable aluminum and "
                    + "glass enclosure. The new integrated Intel HD Graphics 4000 processor"
                    + " boosts performance by up to 60 percent. That extra power gives you "
                    + "a smoother, more fluid experience than before. It’s still highly efficient"
                    + ", too, so you get long battery life when you’re out and about.",30,"img/7.jpg"));
            
            list.add(new Producto ("8","LG Electronics OLED55E6P Flat 55-Inch",2497,"The individually "
                    + "illuminating OLED pixels can brighten, dim and power off fully to achieve perfect "
                    + "black. That means contrast—the ratio between the lightest and darkest areas of the"
                    + " screen—is truly infinite. Perfect black is essential to a more lifelike image as"
                    + " well as the great shadow detail you can only get with OLED.",30,"img/8.jpg"));
           list.add(new Producto ("9","Sony PlayStation 4 Pro",438,"PlayStation Store Cards fill your PSN "
                   + "account wallet with cash, allowing you to download the newest games, DLC, and videos, "
                   + "as well as stream movies and music, all from the PlayStation Store.",30,"img/9.jpg"));
           
            list.add(new Producto ("10","Xbox One S 500GB",275,"The Xbox One S 500GB "
                    + "Console - Battlefield 1 Bundle includes: Xbox One S 500GB Console,"
                    + " full game download of Battlefield 1, one month of EA Access,"
                    + " Xbox Wireless Controller, HDMI cable (4K Capable), Power cable "
                    + "and a 14-day Xbox Live Gold Trial.",30,"img/10.jpg"));
            
            list.add(new Producto ("11","Sony PlayStation Vita WiFi",199,"Take the"
                    + " greatness of PlayStation on the go with the Ultimate"
                    + " Gamer's Companion. On the PlayStation Vita system, gamers"
                    + " can play over 1,000 PlayStation games, stream PS4 games "
                    + "via Remote Play, and stream PS3games via PS Now. This slim"
                    + " and sleek device also features a more immersive gaming experience"
                    + " away from your console and TV.",30,"img/11.jpg"));
            
            list.add(new Producto ("12","Nintendo 3DS - Cosmo Black",294,"Nintendo"
                    + " 3DS combines all the functionality of 3DS XL at an even "
                    + "more affordable price. Play 3DS and DS games, take 3D photos,"
                    + " and connect with friends with StreetPass and SpotPass.\n" +
"\n" +
"Nintendo 3DS includes two screens. The bottom touch screen makes use"
                    + " of a telescoping stylus that is stored in the unit itself."
                    + " The top screen displays 3D visuals to the naked eye. Looking "
                    + "at the screen is like peering through a window into a world where "
                    + "characters and objects have true depth. The system also has a 3D"
                    + " Depth Slider that lets players select the level of 3D they enjoy"
                    + " the most. The 3D effect can be ratcheted up to the highest level, "
                    + "scaled back to a more moderate setting or even turned off completely,"
                    + " depending on the preference of the user.",30,"img/12.jpg"));
           
          System.out.println("cantidad"+list.size());
          HttpSession session = request.getSession();
           session.setAttribute("productsLista", list);
         //processRequest(request, response);
         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("lleva");
        String current = request.getParameter("idCurrent");
        System.out.println(current);
     
        HttpSession session=request.getSession();  
        session.setAttribute("current",current);  
        
         //RequestDispatcher rd = getServletContext().getRequestDispatcher("Agregar.jsp");
         //rd.forward(request, response);
         //rd.forward(request, response);
        response.sendRedirect("Agregar.jsp");
        
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
