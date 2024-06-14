package com.jee.web;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.jee.beans.Inscription;
import com.jee.beans.Stagiaire;
import com.jee.business.Facade;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private Facade f;
    private Inscription i;

    public void init() throws ServletException {
        f = new Facade();
        i = new Inscription();
        i.setId_inscription(f.getIm().get_last_id()+1);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
    	if(uri.contains("login")) {
    		try {
	    		if(authenticate(req.getParameter("username"), req.getParameter("password"))) {
	        		//traitement normale		                	
	                req.setAttribute("ls", f.getSm().getAll(""));
	                System.out.println("GET_ALL STAGE WEB--------------->");
	                req.getRequestDispatcher("views/affichage.jsp").forward(req, resp);	         	
	        	}else {
		    		//gestion de failed login
		    		System.out.println("Login failed !"); 
		            int loginAttempts = 1;
	            
	            	if (req.getSession().getAttribute("loginAttempts") != null) {
	                    loginAttempts = (int) req.getSession().getAttribute("loginAttempts") + 1;
	                }
	                req.getSession().setAttribute("loginAttempts", loginAttempts);
	
	                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
	                    resp.sendRedirect("views/accountLocked.jsp");
	                } else {
	                    req.setAttribute("invalidLogin", true);
	                    req.getRequestDispatcher("views/loginFailed.jsp").forward(req, resp);
	                }
	        	}
    		}catch(Exception e) {
	    		System.out.println(e.getMessage());
	    	}
    	//////////////////////////////////////////////////////////////////////////////
    	}else if (uri.contains("trie")) {
        	try {
        		if(req.getParameter("sortBy").contains("date")){
        			req.setAttribute("sort", "date");
            		req.setAttribute("ls", f.getSm().getAll("date"));
            	}else if(req.getParameter("sortBy").contains("type")) {
        			req.setAttribute("sort", "type");
            		req.setAttribute("ls", f.getSm().getAll("type"));
            	}
        		System.out.println("GET_ALL STAGE WEB--------------->");
                req.getRequestDispatcher("views/affichage.jsp").forward(req, resp);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
        	//////////////////////////////////////////////////////////////////////////////
        }else if (uri.contains("soumettre")) {
        	try { 
        		i.setStage(f.getSm().get(req.getParameter("soumettre")));
        		if(i.getStage() == null) {
	                req.setAttribute("ls", f.getSm().getAll(""));
	                System.out.println("GET_ALL STAGE WEB--------------->");
            		req.setAttribute("error", "Stage non trouvé. Veulliez inserer un code valide!");
                    req.getRequestDispatcher("views/affichage.jsp").forward(req, resp);
        		}else{
        			if(i.getStage().getNbinscrit_stage() >= i.getStage().getNbplace_stage()) {
                		req.setAttribute("error", "Ce stage est complet ! veuillez choisir un autre stage.");
                		req.setAttribute("ls", f.getSm().getAll(""));
    	                System.out.println("GET_ALL STAGE WEB--------------->");
                        req.getRequestDispatcher("views/affichage.jsp").forward(req, resp);
        			}else {
        				req.setAttribute("stage", i.getStage());	
                		System.out.println("GET STAGE WEB--------------->");
        			}
    			}
        		req.setAttribute("li", f.getIm().getAll(i.getStage().getCode_stage()));
        		System.out.println("GET_ALL INSCRIPTION WEB--------------->");
                req.getRequestDispatcher("views/inscription.jsp").forward(req, resp);
             } catch (Exception e) {
				System.out.println(e.getMessage());
			}
        	//////////////////////////////////////////////////////////////////////////////
        }else if (uri.contains("retour")) {
        	try {
        		req.setAttribute("ls", f.getSm().getAll(""));
                System.out.println("GET_ALL STAGE WEB--------------->");
                req.getRequestDispatcher("views/affichage.jsp").forward(req, resp);
                i.setId_inscription(f.getIm().get_last_id()+1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
        	//////////////////////////////////////////////////////////////////////////////
        }else if (uri.contains("nouvelle")) {
            try {
                req.setAttribute("stage", i.getStage());
                req.setAttribute("lsi", f.getSim().getAll());
                String selectedStagiaire = req.getParameter("selectedStagiaire");
            	i.setStagiaire(f.getSim().get(selectedStagiaire));
            	System.out.println("Stagiaire sélectionné : " + selectedStagiaire);
                req.getRequestDispatcher("views/nv_inscription.jsp").forward(req, resp);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        	//////////////////////////////////////////////////////////////////////////////
        }else if(uri.contains("validation")) {
        	//traitement insertions inscription avec succes
        	try {
        		if(req.getParameter("statut")!= null) {
                	i.setSatut_inscrip(req.getParameter("statut").charAt(0));
                	i.setCode_position(req.getParameter("code").charAt(0));
                    i.setDate_inscrip(Date.valueOf(req.getParameter("date")));   
                }
        		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        		String debutString = dateFormat.format(i.getStage().getDebut_stage());
        		String finString = dateFormat.format(i.getStage().getFin_stage());

        		String[] s = {i.getStage().getType_stage(), debutString, finString, String.valueOf(i.getStage().getNbplace_stage()), String.valueOf(i.getStage().getNbinscrit_stage()+1)};
        		f.getSm().update(s, i.getStage().getCode_stage());
                String selectedStagiaire = req.getParameter("selectedStagiaire");
        		if(i.getStagiaire()==null) {
                	i.setStagiaire(f.getSim().get(selectedStagiaire));
                	System.out.println("Stagiaire sélectionné : " + selectedStagiaire);
                }	
        		f.getIm().add(i);
        		for (Inscription  i : f.getIm().getAll(i.getStage().getCode_stage())) {
					System.out.println(i.toString());
					System.out.println("------------------");
				}
        		req.getRequestDispatcher("views/succes.jsp").forward(req, resp);
			} catch (Exception e) {
                System.out.println(e.getMessage());
			}
        	//////////////////////////////////////////////////////////////////////////////
        }else if (uri.contains("nouveauStagiaire")) {
        	//traitement nouveau stagiaire
        	try {
        		req.getRequestDispatcher("views/nv_stagiaire.jsp").forward(req, resp);
			} catch (Exception e) {
                System.out.println(e.getMessage());
			}
        	//////////////////////////////////////////////////////////////////////////////
        }else if(uri.contains("creer")) {
        	try {
        		String num = req.getParameter("num_stagiaire");
        		String nom = req.getParameter("nom_stagiaire");
        		String prenom = req.getParameter("prenom_stagiaire");
        		char sexe = req.getParameter("sexe_stagiaire").charAt(0);
        		Date date = Date.valueOf(req.getParameter("dnaiss_stagiaire"));
        		String diplo = req.getParameter("diplo_stagiaire");
        		
        		Stagiaire st = new Stagiaire(num, nom, prenom, sexe, date, diplo);
        		i.setStagiaire(st);       		
        		f.getSim().add(st);
                req.setAttribute("stage", i.getStage());
                req.setAttribute("lsi", f.getSim().getAll());
        		req.setAttribute("message", "Le stagiaire a bien été créé !");
        		req.getRequestDispatcher("views/nv_inscription.jsp").forward(req, resp);
			} catch (Exception e) {
                System.out.println(e.getMessage());
			}
        	//////////////////////////////////////////////////////////////////////////////
        }else if(uri.contains("ri")) {
        	try {
        		req.setAttribute("stage", i.getStage());
                req.setAttribute("lsi", f.getSim().getAll());
        		req.getRequestDispatcher("views/nv_inscription.jsp").forward(req, resp);
			} catch (Exception e) {
                System.out.println(e.getMessage());
			}
        }
    }

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private boolean authenticate(String username, String password) {
        return (username.equals("kamal") || 
        		username.equals("walid") || 
        		username.equals("hassan") 
        	    ) && password.equals("0000");
    }
}