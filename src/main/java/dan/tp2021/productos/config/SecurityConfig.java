package dan.tp2021.productos.config;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/public/**")
                .hasAuthority("lectura")
                .antMatchers(HttpMethod.GET, "/api/private/**")
                .hasAuthority("escritura")
                .antMatchers(HttpMethod.GET, "/api/admin/**")
                .hasAuthority("administracion")
                .anyRequest().authenticated()
                .and() .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(new CustomJwtAuthenticationConverter());
    }